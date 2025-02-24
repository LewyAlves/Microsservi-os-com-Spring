package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;

public class RendaMaiorValorSolicitado implements CalculoPonto {
    @Override
    public int calcular(PropostaEntity proposta) {
        return rendaMaiorValorSolicitado(proposta) ? 100 : 0;
    }

    private boolean rendaMaiorValorSolicitado(PropostaEntity proposta){
        return proposta.getUsuario().getRenda() > proposta.getValorSolicitado();
    }
}
