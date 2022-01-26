package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    @ConditionalOnProperty(name="serviceImpl.enabled", havingValue = "one")
    public MyService myService1(){
        return new MyServiceImpl1();
    }

    @Bean
    @ConditionalOnProperty(name="serviceImpl.enabled", havingValue = "two", matchIfMissing = true)
    public MyService myService2(){
        return new MyServiceImpl2();
    }
}
