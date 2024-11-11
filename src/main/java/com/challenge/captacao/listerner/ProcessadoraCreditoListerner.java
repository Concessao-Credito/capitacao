package com.challenge.captacao.listerner;

import com.challenge.captacao.config.RabbitMQConfig;
import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;
import com.challenge.captacao.service.CaptacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProcessadoraCreditoListerner {
    private final CaptacaoService service;

    @RabbitListener(queues = RabbitMQConfig.CAPTACAO_QUEUE)
    public void receiveMessage(ProcessadoraCreditoCompletoRequest message) {
        service.process(message);
    }
}
