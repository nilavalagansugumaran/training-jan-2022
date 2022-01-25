package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyProfilesDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MyProfilesDemoApplication.class, args);

		ctx.getBean(MyBeans.class).printMyName();
	}

}
