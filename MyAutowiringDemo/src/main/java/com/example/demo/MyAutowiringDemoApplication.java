package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAutowiringDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MyAutowiringDemoApplication.class, args);
		ctx.getBean(BankComponent.class).takeDeposit();
	}

}
