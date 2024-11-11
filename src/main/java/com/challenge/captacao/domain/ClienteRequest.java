package com.challenge.captacao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ClienteRequest {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String rg;
    private String cep;
    private String endereco;
    private String profissao;
    private BigDecimal renda;
}
