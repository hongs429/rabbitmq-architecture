package com.rabbitmq.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;



@SpringBootApplication
@ComponentScan(basePackages = "com.rabbitmq.architecture.step1")
public class RabbitmqArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqArchitectureApplication.class, args);
    }

}
