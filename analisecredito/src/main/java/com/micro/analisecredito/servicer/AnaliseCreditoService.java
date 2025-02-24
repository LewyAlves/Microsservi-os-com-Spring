package com.micro.analisecredito.servicer;

import com.micro.analisecredito.entity.PropostaEntity;
import com.micro.analisecredito.servicer.strategy.CalculoPonto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnaliseCreditoService {

    private List<CalculoPonto> calculoPontos;

    public void analisar(PropostaEntity proposta){
        int pontuacao = calculoPontos.stream()
                .mapToInt(impl -> impl.calcular(proposta))
                .sum();
    }
}
