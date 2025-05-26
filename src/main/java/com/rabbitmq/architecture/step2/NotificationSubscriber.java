package com.rabbitmq.architecture.step2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationSubscriber {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ObjectMapper objectMapper;

    public static final String CLIENT_URL = "/topic/notifications";

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void subscribeNotification(String message) {
        log.info("Received notification: {}", message);
        simpMessagingTemplate.convertAndSend(CLIENT_URL,message);
    }
}
