package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverComponent {

    @RabbitListener(queues = "demo.queue")
    public void receiveMessage(@Payload Employee employee, @Header(name ="myheader") String headerValue){
        System.out.println(employee.toString());
        System.out.println(headerValue);
    }
}
