package com.micro.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

    @Autowired
    private AmazonSNS amazonSNS;

    public void  notificar(String mensagem, String telefone){
        PublishRequest publishRequest = new PublishRequest().withMessage(mensagem).withPhoneNumber(telefone);
        System.out.println(publishRequest);
        amazonSNS.publish(publishRequest);
    }
}
