package com.rabbitmq.architecture.step2;


import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompController {

    private final NotificationPublisher notificationPublisher;

    @MessageMapping("/send")
    public void send(NotificationMessage message) {
        notificationPublisher.publishNotification(message.getMessage());
    }
}
