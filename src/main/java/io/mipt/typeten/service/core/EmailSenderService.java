package io.mipt.typeten.typeten.service.core;

public interface EmailSenderService {
    void sendRegistrationEmail(String email, String code);
}
