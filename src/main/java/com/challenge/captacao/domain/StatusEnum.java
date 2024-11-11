package com.challenge.captacao.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.ALWAYS)
public enum StatusEnum {
    APROVADO,
    REPROVADO,
    COM_ERRO
}
