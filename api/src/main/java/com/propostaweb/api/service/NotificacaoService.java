package com.propostaweb.api.service;

import com.propostaweb.api.dto.PropostaResponseDto;
import com.propostaweb.api.entity.PropostaEntity;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(PropostaEntity proposta, String exchange){
        rabbitTemplate.convertAndSend(exchange, "",proposta);
    }
}
