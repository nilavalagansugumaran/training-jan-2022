package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoActiveMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoActiveMqApplication.class, args);
		ctx.getBean(SenderComponent.class).sendMessage("Hello there...");
	}

}
