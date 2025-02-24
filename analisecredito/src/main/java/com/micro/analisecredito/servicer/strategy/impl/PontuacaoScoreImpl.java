package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;

import java.util.Random;

public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(PropostaEntity proposta) {
        int score = score();

        if (score <= 200){
            throw new RuntimeException("score abaixo");
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
