package com.propostaweb.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proposta")
public class PropostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private boolean integrada;
    private String observacao;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
}
