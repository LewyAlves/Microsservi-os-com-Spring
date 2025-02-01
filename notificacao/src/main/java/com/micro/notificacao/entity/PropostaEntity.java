package com.micro.notificacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropostaEntity {
    private Long id;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private boolean aprovada;
    private boolean integrada;
    private String observacao;
    private UsuarioEntity usuario;
}
