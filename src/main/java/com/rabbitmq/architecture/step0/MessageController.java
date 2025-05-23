package com.rabbitmq.architecture.step0;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final RabbitSender rabbitSender;

    public MessageController(RabbitSender rabbitSender) {
        this.rabbitSender = rabbitSender;
    }

    @PostMapping("/actions/send")
    public String sendMessage(@RequestBody String message) {
        rabbitSender.send(message);
        return "Message sent" + message;
    }
}
