package br.com.authentication.config.api;

import br.com.authentication.enums.ERole;
import br.com.authentication.model.Role;
import br.com.authentication.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;
import java.util.UUID;

@Configuration
public class ApiConfiguration {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	roleRepository.save(new Role(UUID.fromString("7bb333d0-0baa-483c-a2f8-0a17129e3e75"),ERole.ROLE_ADMIN));
	    	roleRepository.save(new Role(UUID.fromString("47f3a552-6c2b-4f35-853d-ea003f70bdf4"),ERole.ROLE_MODERATOR));
	    	roleRepository.save(new Role(UUID.fromString("abb76def-c9b7-446c-bc8a-e6f40454ef65"),ERole.ROLE_USER));
	      };
	 }
	
	@Bean
	public void timeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
	
}
