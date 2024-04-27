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

    //private final JavaMailSender javaMailSender;

    @Value("${type10.fromAddress}")
    private String fromEmailAddress;

    @Override
    public void sendRegistrationEmail(String email, String code) {
        log.info("Sending registration email to " + email);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Shlim-tech registration Email");
        message.setText("Your registration code is " + code);
        message.setFrom(fromEmailAddress);

        //javaMailSender.send(message);
    }
}
