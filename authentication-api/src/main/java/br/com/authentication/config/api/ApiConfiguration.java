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

		UUID uuid = UUID.randomUUID();

	    return () -> {
	    	roleRepository.save(new Role(uuid,ERole.ROLE_ADMIN));
	    	roleRepository.save(new Role(uuid,ERole.ROLE_MODERATOR));
	    	roleRepository.save(new Role(uuid,ERole.ROLE_USER));
	      };
	 }
	
	@Bean
	public void timeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
	
}
