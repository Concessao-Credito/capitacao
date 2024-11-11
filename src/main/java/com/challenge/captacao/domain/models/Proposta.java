package com.challenge.captacao.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PropostaSequence")
    @SequenceGenerator(name = "PropostaSequence", allocationSize = 1)
    private Long id;

    @OneToOne
    private Cliente clienteId;

    @Column(nullable = false)
    private Boolean ativa;

    @Column(nullable = false)
    private BigDecimal valorLiberado;
}
