package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;

import java.util.Random;

public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(PropostaEntity proposta) {
        if (nomeNegativado()){
            throw new RuntimeException("Nome negativado");
        }
        return 100;
    }


    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
