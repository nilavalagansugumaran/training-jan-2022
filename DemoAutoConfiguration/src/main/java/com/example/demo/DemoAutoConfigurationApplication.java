package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAutoConfigurationApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoAutoConfigurationApplication.class, args);
		ctx.getBean(MyService.class).doSomething(); // this will give error because there are two beans,
													// cant decide which one to use

		//ctx.getBean("myService1",MyService.class).doSomething(); // this will work as it can find the right bean
	}

}
