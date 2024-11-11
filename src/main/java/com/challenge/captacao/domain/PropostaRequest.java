package com.challenge.captacao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PropostaRequest {
    private Boolean ativa;
    private BigDecimal valorLiberado;
}
