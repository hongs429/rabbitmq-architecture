package com.rabbitmq.architecture.step0;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitReceiver {

    public void receiveMessage(String message) {
        log.info("Received <{}>", message);
    }
}
