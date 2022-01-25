package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Lazy
public class MyConfig {

    @Bean(name = {"myOwnBean","myOwnBean1", "myOwnBean2", "myOwnBean3"})
    @Scope
    public MyOwnBean myOwnBean1(){

        return myOwnBean();
    }

    public MyOwnBean myOwnBean(){

        return new MyOwnBean();
    }
}
