package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.exceptions.StrategyException;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(PropostaEntity proposta) {
        if (nomeNegativado()){
            throw new StrategyException("Nome negativado");
        }
        return 100;
    }


    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
