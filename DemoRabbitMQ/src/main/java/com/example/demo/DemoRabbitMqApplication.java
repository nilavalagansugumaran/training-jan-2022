package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRabbitMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoRabbitMqApplication.class, args);
		ctx.getBean(RabbitSenderComponent.class).sendMessage(new Employee("nila-1", "nila1@nila.com"));
	}

}
