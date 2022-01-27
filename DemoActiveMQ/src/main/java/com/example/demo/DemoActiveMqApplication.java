package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class DemoActiveMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoActiveMqApplication.class, args);
		ctx.getBean(SenderComponent.class).sendMessage("Hello there...");
		ctx.getBean(SenderComponent.class).sendMessage(new Employee("nila", "nila@nila.com"));
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter(){
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_id");
		return converter;
	}
}
