package org.shlimtech.typeten.typeten.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(value="type10.rabbitenabled", matchIfMissing = false)
@EnableRabbit
@Configuration
public class RabbitConfig {

    @Bean
    public Queue registrationQueue(@Value("${type10.registration-email-send-queue-name}") String queueName) {
        return new Queue(queueName);
    }

}
