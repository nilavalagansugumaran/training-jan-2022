package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HSBCBankService implements BankService{

    @Autowired private BankRespository bankRespository;

    @Override
    public void doDeposit() {
        System.out.println("HSBCBankService taking deposit");
        bankRespository.deposit();
    }
}
