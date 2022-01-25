package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankComponent {

    @Value("${name:xxxxxx}")
    private String accountName;

    @Autowired
    //@Qualifier("lloydsBankService")
    private List<BankService> bankService;

    public void takeDeposit() {
        System.out.println("BankComponent taking deposit for " + accountName);

        for(BankService bank: bankService) {
            bank.doDeposit();
        }
    }
}
