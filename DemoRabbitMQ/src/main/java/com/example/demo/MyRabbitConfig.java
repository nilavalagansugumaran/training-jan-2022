package com.example.demo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue(){
        return QueueBuilder.durable("demo.queue").build();
    }

    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.directExchange("demo.exchange").build();
    }

    @Bean
    public Binding binding(Queue q, Exchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("demo.key").noargs();
    }
}
