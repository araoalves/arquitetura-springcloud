package br.com.fornecedor.jwt;

import br.com.fornecedor.clients.AuthenticationClient;
import br.com.fornecedor.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private String _body;

	@Autowired
	private AuthenticationClient authenticationClient;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(email)
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

		return null;
	}

	public UserDetails loadUserByUser() {

		User user = authenticationClient.getUser();

		System.out.println(user);

		//JwtResponse jwtResponse = authenticationClient.login()

		//User user =

		//return UserDetailsImpl.build(user);

		return UserDetailsImpl.build(user);
	}
}
