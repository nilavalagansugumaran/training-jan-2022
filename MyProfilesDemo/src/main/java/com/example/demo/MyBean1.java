package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cloud")
public class MyBean1 implements MyBeans{

    @Override
    public void printMyName() {
        System.out.println("MyBean1");
    }
}
