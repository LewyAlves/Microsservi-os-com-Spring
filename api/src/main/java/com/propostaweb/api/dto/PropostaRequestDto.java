package com.propostaweb.api.dto;

public record PropostaRequestDto(String nome,
                                 String sobrenome,
                                 String telefone,
                                 String cpf,
                                 Double renda,
                                 Double valorSolicitado,
                                 Integer prazoPagamento,
                                 Boolean aprovado,
                                 String observacao
) {
}
