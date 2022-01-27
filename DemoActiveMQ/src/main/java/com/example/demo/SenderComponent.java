package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SenderComponent {

    @Autowired private JmsTemplate jmsTemplate;

    public void sendMessage(String str){
        System.out.println("Sending message...");
        jmsTemplate.convertAndSend("destination-1", str);
        System.out.println("Sending message complete...");
    }

    public void sendMessage(Employee employee){
        System.out.println("Sending employee message...");
        jmsTemplate.convertAndSend("destination-2", employee);
        System.out.println("Sending employee message complete...");
    }
}
