package com.rabbitmq.architecture.step1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WorkQueueConsumer {

    public void workQueueTask(String message) {
        String[] messageParts = message.split("\\|");
        String originMessage = messageParts[0];
        int duration = Integer.parseInt(messageParts[1].trim());

        log.info("Processing message: {} for {} ms", originMessage, duration);

        try {
            log.info("Sleeping for {} ms", duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("Message processed: {}", originMessage);
    }
}
