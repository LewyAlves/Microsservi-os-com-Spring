package com.micro.notificacao.listener;

import com.micro.notificacao.constante.MensagemConstante;
import com.micro.notificacao.entity.PropostaEntity;
import com.micro.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(PropostaEntity proposta){
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        String telefone = proposta.getUsuario().getTelefone();
        notificacaoSnsService.notificar(mensagem, telefone);
    }

}
