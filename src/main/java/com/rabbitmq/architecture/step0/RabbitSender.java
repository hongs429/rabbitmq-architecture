package com.rabbitmq.architecture.step0;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitSender {

    private final RabbitTemplate rabbitTemplate;

    public RabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        log.info("Sent message: {}", message);
    }
}
