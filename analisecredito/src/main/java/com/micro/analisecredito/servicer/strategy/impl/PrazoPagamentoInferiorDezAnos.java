package com.micro.analisecredito.servicer.strategy.impl;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;

public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {
    @Override
    public int calcular(PropostaEntity proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
