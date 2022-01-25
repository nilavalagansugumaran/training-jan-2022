package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Demo1Application.class, args);

        System.out.println(ctx.getBean(MyContact.class).toString());
    }

}
