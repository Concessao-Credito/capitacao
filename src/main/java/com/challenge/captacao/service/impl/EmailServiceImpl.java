package com.challenge.captacao.service.impl;

import com.challenge.captacao.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void enviarEmail(String para, String assunto, Map<String, Object> variaveis)
            throws MessagingException, IOException {

        Context context = new Context();
        context.setVariables(variaveis);

        String body = templateEngine.process("email-template", context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setTo(para);
        helper.setSubject("Bem-vindo!");
        helper.setText(body, true);

        mailSender.send(mimeMessage);
    }
}