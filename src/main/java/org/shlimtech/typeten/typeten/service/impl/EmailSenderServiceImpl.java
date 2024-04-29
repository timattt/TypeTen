package org.shlimtech.typeten.typeten.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.shlimtech.typeten.typeten.service.core.EmailSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Override
    public void sendRegistrationEmail(String email, String code) {
        log.info("Sending registration email to " + email);
        log.info("Creds: user=" + username + ", password=" + password);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Registration on shlim-tech.ru");
        message.setTo(email);
        message.setText(code);
        message.setFrom(username);

        javaMailSender.send(message);

        log.info("Messages to " + email + " sent!");
    }
}
