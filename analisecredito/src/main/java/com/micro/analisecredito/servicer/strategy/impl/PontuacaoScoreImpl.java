package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.constants.MensagemConstantes;
import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.exceptions.StrategyException;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(PropostaEntity proposta) {
        int score = score();

        if (score < 200){
            throw new StrategyException(String.format(MensagemConstantes.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
        } else if (score <= 400) {
            return 180;
        } else {
            return 220;
        }
    }

    private int score(){
        return new Random().nextInt(0,1000);
    }
}
