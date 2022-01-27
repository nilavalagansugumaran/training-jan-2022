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
}
