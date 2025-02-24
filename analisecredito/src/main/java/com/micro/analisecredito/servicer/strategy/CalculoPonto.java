package com.micro.analisecredito.servicer.strategy;

import com.micro.analisecredito.entity.PropostaEntity;

public interface CalculoPonto {

    int calcular(PropostaEntity proposta);
}
