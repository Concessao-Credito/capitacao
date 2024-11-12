package com.challenge.captacao.service;

import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void enviarEmail(String para, String assunto, Map<String, Object> variaveis, String template)
            throws MessagingException, IOException;
}
