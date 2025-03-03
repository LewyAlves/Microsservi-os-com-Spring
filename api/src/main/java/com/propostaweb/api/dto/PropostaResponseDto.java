package com.propostaweb.api.dto;

public record PropostaResponseDto(Long id,
                                  String nome,
                                  String sobrenome,
                                  String telefone,
                                  String cpf,
                                  Double renda,
                                  String valorSolicitadoFmt,
                                  Integer prazoPagamento,
                                  Boolean aprovada,
                                  String observacao
)
{
}
