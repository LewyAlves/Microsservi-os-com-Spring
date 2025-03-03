package com.propostaweb.api.listener;

import com.propostaweb.api.entity.PropostaEntity;
import com.propostaweb.api.repository.PropostaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropostaConcluidaListener {

    @Autowired
    private PropostaRepository propostaRepository;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluida(PropostaEntity proposta){
        propostaRepository.save(proposta);
    }
}
