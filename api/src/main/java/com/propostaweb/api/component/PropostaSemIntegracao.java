package com.propostaweb.api.component;

import com.propostaweb.api.entity.PropostaEntity;
import com.propostaweb.api.repository.PropostaRepository;
import com.propostaweb.api.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class PropostaSemIntegracao {

    @Autowired
    private PropostaRepository repository;

    @Autowired
    private NotificacaoService notificacaoService;

    private final Logger logger = Logger.getLogger(String.valueOf(PropostaSemIntegracao.class));

    @Value("${rabbitmq.propostapendente.exchenge}")
    private String exchange;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscarPropostaSemIntegracao() {
        repository.findAllByIntegradaIsFalse()
                .forEach(this::reprocessarNotificacao);
    }

    private void reprocessarNotificacao(PropostaEntity p) {
        try {
            notificacaoService.notificar(p, exchange);
            p.setIntegrada(true);
            repository.save(p);
        } catch (RuntimeException e) {
            logger.info(e.getMessage());
        }
    }
}
