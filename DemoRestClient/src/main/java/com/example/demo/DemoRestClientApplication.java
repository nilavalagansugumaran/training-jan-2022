package com.example.demo;

import com.example.demo.component.RestServiceCaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRestClientApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoRestClientApplication.class, args);
		ctx.getBean(RestServiceCaller.class).callAnotherMicroService();
	}

}
