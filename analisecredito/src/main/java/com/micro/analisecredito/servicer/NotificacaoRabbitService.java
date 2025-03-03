package com.micro.analisecredito.servicer;

import com.micro.analisecredito.entity.PropostaEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoRabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(String exchange, PropostaEntity proposta){
        rabbitTemplate.convertAndSend(exchange,"",proposta);
    }
}
