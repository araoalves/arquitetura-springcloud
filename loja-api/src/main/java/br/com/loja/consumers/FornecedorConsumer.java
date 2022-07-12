package br.com.loja.consumers;

import br.com.loja.models.Fornecedor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FornecedorConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${fornecedor.bocker.queue.fornecedorEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${fornecedor.bocker.exchange.fornecedorEventExchang}", type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true"))
    )
    public void listenFornecedorEvent(@Payload Fornecedor fornecedor) {
        System.out.println(fornecedor);
    }

}
