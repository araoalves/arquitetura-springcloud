package br.com.authentication.util;

import br.com.authentication.model.User;
import br.com.authentication.repository.UserRepository;
import br.com.authentication.services.jwt.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class UsuarioLogadoUtils {

	@Autowired
	private UserRepository userRepository;
	
	 public User recuperarUsuarioLogado(){
		 UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 return userRepository.findById(user.getId()).get();
	 }
}
