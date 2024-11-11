package com.challenge.captacao.service;

import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;

public interface CaptacaoService {
    void process(ProcessadoraCreditoCompletoRequest message);
}
