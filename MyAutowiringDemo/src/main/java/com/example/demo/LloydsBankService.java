package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LloydsBankService implements BankService{

    @Autowired private BankRespository bankRespository;

    @Override
    public void doDeposit() {
        System.out.println("LloydsBankService taking deposit");
        bankRespository.deposit();
    }
}
