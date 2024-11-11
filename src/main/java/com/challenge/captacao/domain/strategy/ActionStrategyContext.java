package com.challenge.captacao.domain.strategy;

import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;
import com.challenge.captacao.domain.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Component
@Slf4j
public class ActionStrategyContext {

    private static final String ERROR_MESSAGE = "Unsupported action {} ";

    private final Map<StatusEnum, ActionStrategy> strategyMap = new EnumMap<>(StatusEnum.class);

    public ActionStrategyContext(EmailFalhaAction emailFalhaAction, EmailSucessoAction emailSucessoAction) {
        strategyMap.put(StatusEnum.APROVADO, emailSucessoAction);
        strategyMap.put(StatusEnum.COM_ERRO, emailFalhaAction);
        strategyMap.put(StatusEnum.REPROVADO, emailFalhaAction);
    }

    public void executeStrategy(ProcessadoraCreditoCompletoRequest request) {
        try {
            var strategy = strategyMap.get(request.getStatusEnum());
            if (nonNull(strategy)) {
                strategy.execute(request);
            }
        } catch (Exception e) {
            log.error(ERROR_MESSAGE, request, e);
            throw new UnsupportedOperationException(ERROR_MESSAGE + request);
        }
    }

}