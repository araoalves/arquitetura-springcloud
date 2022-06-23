package br.com.authentication.services.jwt;

import br.com.authentication.config.jwt.JwtUtils;
import br.com.authentication.enums.ERole;
import br.com.authentication.model.Role;
import br.com.authentication.model.User;
import br.com.authentication.model.reponse.JwtResponse;
import br.com.authentication.model.request.LoginRequest;
import br.com.authentication.model.request.SignupRequest;
import br.com.authentication.repository.RoleRepository;
import br.com.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class JwtUserDetailsService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;

	public User save(@Validated SignupRequest signUpRequest) throws Exception {
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			throw new Exception("Usuário já existente!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new Exception("E-mail já existente!");
		}

		return createdUser(signUpRequest);
	}
	
	public void loadUser(@Validated SignupRequest signUpRequest) {
		if (!(userRepository.existsByUsername(signUpRequest.getUsername()) || userRepository.existsByEmail(signUpRequest.getEmail()))) {
			createdUser(signUpRequest);
		}
	}
	
	public User createdUser(@Valid SignupRequest signUpRequest) {
				User user = new User(signUpRequest.getNome(),
									 signUpRequest.getTelefone(),
									 signUpRequest.getUsername(), 
									 signUpRequest.getEmail(),
									 encoder.encode(signUpRequest.getPassword()));

				Set<String> strRoles = signUpRequest.getRole();
				Set<Role> roles = new HashSet<>();

				if (strRoles == null) {
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				} else {
					strRoles.forEach(role -> {
						switch (role) {
						case "ROLE_ADMIN":
							Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
							roles.add(adminRole);

							break;
						case "ROLE_MODERATOR":
							Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
							roles.add(modRole);

							break;
						default:
							Role userRole = roleRepository.findByName(ERole.ROLE_USER)
									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
							roles.add(userRole);
						}
					});
				}

				user.setRoles(roles);
				return userRepository.save(user);
	}

	public JwtResponse login(@Valid LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		JwtResponse response = new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles,
				 userDetails.getNome());
		
		return response;
	}

}
