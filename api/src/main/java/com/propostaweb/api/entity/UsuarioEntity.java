package com.propostaweb.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;
    @OneToOne(mappedBy = "usuario")
    private PropostaEntity proposta;
}
