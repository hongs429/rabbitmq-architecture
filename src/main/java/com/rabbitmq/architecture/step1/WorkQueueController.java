package com.rabbitmq.architecture.step1;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WorkQueueController {

    private final WorkQueueProducer producer;

    @PostMapping("/work-queue/actions/send")
    public String sendWorkQueueMessage(@RequestParam String workQueueMessage,@RequestParam int duration) {
        producer.sendWorkQueue(workQueueMessage, duration);
        return "Work queue sent = " + workQueueMessage + " for " + duration + " ms";
    }
}
