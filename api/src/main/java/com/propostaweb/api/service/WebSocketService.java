package com.propostaweb.api.service;

import com.propostaweb.api.dto.PropostaResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void notificar(PropostaResponseDto response){
        template.convertAndSend("/propostas", response);
    }
}
