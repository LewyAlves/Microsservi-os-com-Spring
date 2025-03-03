package com.micro.analisecredito.servicer;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.exceptions.StrategyException;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontos;

    @Autowired
    private NotificacaoRabbitService notificacaoRabbitService;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public void analisar(PropostaEntity proposta){
        try {
            boolean aprovada = calculoPontos.stream()
                    .mapToInt(impl -> impl.calcular(proposta))
                    .sum() > 350;
            proposta.setAprovada(aprovada);
        } catch (StrategyException ex){
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitService.notificar(exchangePropostaConcluida,proposta);
    }
}
