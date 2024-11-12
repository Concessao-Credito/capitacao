package com.challenge.captacao.domain.strategy;

import com.challenge.captacao.domain.ProcessadoraCreditoCompletoRequest;
import com.challenge.captacao.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailSucessoAction implements ActionStrategy {
    private final EmailService emailService;

    @Override
    public void execute(ProcessadoraCreditoCompletoRequest request) {
        Map<String, Object> variaveis = new HashMap<>();
        variaveis.put("nome", request.getClienteRequest().getNome());
        variaveis.put("valor", request.getPropostaRequest().getValorLiberado());

        try {
            emailService.enviarEmail(
                    request.getClienteRequest().getEmail(),
                    "Resultado Conciliação Credito",
                    variaveis,
                    "email-sucesso.html");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
