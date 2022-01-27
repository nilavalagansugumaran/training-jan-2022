package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverComponent {

    @JmsListener(destination = "destination-1")
    public void receiveMessage(String str){
        System.out.println("Message received...");
        System.out.println(str);
    }

    @JmsListener(destination = "destination-2")
    public void receiveMessage(Employee employee){
        System.out.println("Employee Message received...");
        System.out.println(employee);
    }
}
