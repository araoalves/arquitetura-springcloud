package br.com.authentication.publishers;

import br.com.authentication.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${authentication.bocker.exchange.authenticationEventExchang}")
    private String exchangAuthenticationEvent;

    public void publishAuthenticationEvent(User user){
        rabbitTemplate.convertAndSend(exchangAuthenticationEvent, "", user);
    }
}
