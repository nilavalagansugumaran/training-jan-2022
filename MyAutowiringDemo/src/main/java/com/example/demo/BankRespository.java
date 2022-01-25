package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class BankRespository {

    @Autowired private ApplicationArguments applicationArguments;

    public void deposit(){

        System.out.println("Adding money to account...");
        System.out.println(applicationArguments.getNonOptionArgs());
        System.out.println(applicationArguments.getOptionNames());
        Arrays.stream(applicationArguments.getSourceArgs()).forEach(s -> System.out.println(s));
        System.out.println(applicationArguments.getOptionValues("key1"));

    }
}
