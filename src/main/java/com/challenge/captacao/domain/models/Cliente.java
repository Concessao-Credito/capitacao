package com.challenge.captacao.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClientSequence")
    @SequenceGenerator(name = "ClientSequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cpf;

    private String rg;

    private LocalDate dataNascimento;

    private String profissao;

    private BigDecimal renda;

}
