package br.com.fornecedor.publishers;

import br.com.fornecedor.models.Fornecedor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FornecedorEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${fornecedor.bocker.exchange.fornecedorEventExchang}")
    private String exchangFornecedorEvent;

    public void publishFornecedorEvent(Fornecedor fornecedor){
        rabbitTemplate.convertAndSend(exchangFornecedorEvent, "", fornecedor);
    }
}
