package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("newMyBean")
//@Component
@Scope("prototype")
@Lazy
public class MyBean {

    public void doSomething(){
        System.out.println("I am doing great stuff");
    }
}
