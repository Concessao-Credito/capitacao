package com.challenge.captacao.service.impl;

import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;
import com.challenge.captacao.domain.models.Cliente;
import com.challenge.captacao.domain.models.Proposta;
import com.challenge.captacao.domain.strategy.ActionStrategyContext;
import com.challenge.captacao.repository.ClienteRepository;
import com.challenge.captacao.repository.PropostaRepository;
import com.challenge.captacao.service.CaptacaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptacaoServiceImpl implements CaptacaoService {

    private final ClienteRepository clienteRepository;
    private final PropostaRepository propostaRepository;
    private final ActionStrategyContext actionStrategyContext;
    private final ModelMapper modelMapper;

    @Override
    public void process(ProcessadoraCreditoCompletoRequest message) {
        if (message.getClienteRequest() == null) {
            throw new RuntimeException();
        }

        Cliente map = modelMapper
                .map(message.getClienteRequest(), Cliente.class);

        Cliente cliente = clienteRepository
                .save(map);

        criarEntidadeProposta(message, cliente);

        actionStrategyContext.executeStrategy(message);
    }

    private void criarEntidadeProposta(ProcessadoraCreditoCompletoRequest message, Cliente cliente) {
        if (message.getPropostaRequest() != null) {
            Proposta proposta = modelMapper
                    .map(message.getPropostaRequest(), Proposta.class);
            saveProposta(cliente, proposta);
        }
    }

    private void saveProposta(Cliente cliente, Proposta proposta) {
        if (proposta != null) {
            proposta.setClienteId(cliente);
            propostaRepository.save(proposta);
        }
    }
}
