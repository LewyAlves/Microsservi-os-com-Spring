package com.micro.analisecredito.listener;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    @Autowired
    private AnaliseCreditoService analiseCreditoService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(PropostaEntity proposta){
        analiseCreditoService.analisar(proposta);
    }
}
