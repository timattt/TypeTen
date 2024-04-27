package org.shlimtech.typeten.typeten.service.core;

public interface EmailSenderService {
    void sendRegistrationEmail(String email, String code);
}
