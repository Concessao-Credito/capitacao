package com.challenge.captacao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ProcessadoraCreditoCompletoRequest {
    private ClienteRequest clienteRequest;
    private PropostaRequest propostaRequest;
    private StatusEnum statusEnum;
}
