package org.shlimtech.typeten.typeten.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.java.Log;
import org.shlimtech.typeten.typeten.service.core.EmailSenderService;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.Serializable;

@Component
@Log
@RequiredArgsConstructor
public class RabbitAdapter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final EmailSenderService emailSenderService;

    @RabbitListener(queues = "${type10.registration-email-send-queue-name}")
    @SneakyThrows
    public void receiveRegistrationMessage(String message) {
        log.info("Received from registration queue: " + message);
        RegistrationQueueMessage queueMessage = objectMapper.readValue(message, RegistrationQueueMessage.class);
        emailSenderService.sendRegistrationEmail(queueMessage.email, queueMessage.code);
    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegistrationQueueMessage implements Serializable {
        private String code;
        private String email;
    }
}
