package com.micro.notificacao.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioEntity {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;
}
