package com.example.PIM.service;

import com.example.PIM.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    public List<Account> getAccounts(){
        Account account = new Account(1, "admin", "admin@gmail.com");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        return accounts;
    }
}
