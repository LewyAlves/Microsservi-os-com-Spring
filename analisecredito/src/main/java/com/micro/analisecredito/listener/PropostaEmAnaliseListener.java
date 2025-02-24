package com.micro.analisecredito.listener;

import com.micro.analisecredito.entity.PropostaEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(PropostaEntity proposta){

    }
}
