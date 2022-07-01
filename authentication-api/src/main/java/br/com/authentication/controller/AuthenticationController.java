package br.com.authentication.controller;

import br.com.authentication.model.request.LoginRequest;
import br.com.authentication.model.request.SignupRequest;
import br.com.authentication.services.jwt.JwtUserDetailsService;
import br.com.authentication.util.UsuarioLogadoUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
public class AuthenticationController {		

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UsuarioLogadoUtils usuarioLogadoUtils;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		return ResponseEntity.ok(userDetailsService.login(loginRequest));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody SignupRequest signUpRequest) throws Exception {
		try {
			return new ResponseEntity<>(userDetailsService.save(signUpRequest), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<?> getUser() throws Exception {
		try {
			return new ResponseEntity<>(usuarioLogadoUtils.recuperarUsuarioLogado(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}