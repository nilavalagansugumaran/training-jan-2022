package com.example.demo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "contact")
@Data
@ToString
public class MyContact {

    private String name;
    private String email;
    private Address address;

    @Data
    public static class Address {

        private String line;
        private String postcode;
    }
}
