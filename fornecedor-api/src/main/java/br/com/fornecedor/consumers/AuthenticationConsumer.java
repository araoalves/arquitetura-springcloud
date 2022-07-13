package br.com.fornecedor.consumers;

import br.com.fornecedor.models.User;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${authentication.bocker.queue.authenticationEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${authentication.bocker.exchange.authenticationEventExchang}", type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true"))
    )
    public void listenFornecedorEvent(@Payload User user) {
        System.out.println(user);
    }
}
