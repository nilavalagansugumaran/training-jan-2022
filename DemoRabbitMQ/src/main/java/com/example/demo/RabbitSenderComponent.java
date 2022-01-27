package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSenderComponent {

    @Autowired private RabbitTemplate rabbitTemplate;

    public void sendMessage(Employee employee){
        rabbitTemplate.convertAndSend("demo.exchange", "demo.key", employee,
                message -> {
                    message.getMessageProperties().setHeader("myheader", "123");
                    return message;
                });
    }
}
