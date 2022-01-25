package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class MyBean2 implements MyBeans{
    @Override
    public void printMyName() {
        System.out.println("MyBean2");
    }
}
