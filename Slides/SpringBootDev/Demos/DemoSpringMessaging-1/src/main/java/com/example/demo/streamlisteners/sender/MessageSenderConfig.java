package com.example.demo.streamlisteners.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MessageSenderConfig {

	  @Value("${destination:test}")
	  private String destination;

	  @Bean
	  public DirectChannel messageSenderChannel() {
	    return new DirectChannel();
	  }

	  @Bean
	  @ServiceActivator(inputChannel = "messageSenderChannel")
	  public MessageHandler jmsMessageHandler(JmsTemplate jmsTemplate) {
	    JmsSendingMessageHandler handler =
	        new JmsSendingMessageHandler(jmsTemplate);
	    handler.setDestinationName(destination);
	    return handler;
	  }
}
