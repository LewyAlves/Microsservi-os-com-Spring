package com.propostaweb.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropostaResponseDto
{
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String cpf;
    private Double renda;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovado;
    private String observacao;
}
