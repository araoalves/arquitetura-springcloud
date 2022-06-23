package br.com.authentication.controller;

import br.com.authentication.model.request.LoginRequest;
import br.com.authentication.model.request.SignupRequest;
import br.com.authentication.services.jwt.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
public class AuthenticationController {		

	@Autowired
	private JwtUserDetailsService userDetailsService;

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

}