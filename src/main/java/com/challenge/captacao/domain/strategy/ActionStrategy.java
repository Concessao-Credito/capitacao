package com.challenge.captacao.domain.strategy;

import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;

public interface ActionStrategy {

    void execute(ProcessadoraCreditoCompletoRequest request);

}
