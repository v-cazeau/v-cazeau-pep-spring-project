package com.example.service;

import com.example.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.naming.AuthenticationException;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();
    private MessageService messageService;

    @Autowired
    public AccountService (MessageService messageService) {
        this.messageService = messageService;
    }

    // #1 process new User registrations.
    public void register(Account newAccount) {
        accounts.add(newAccount);
    }

   //#2 process User logins.
    public void login(String username, String password) throws AuthenticationException {
        for (Account account:accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return;
            };
        }
        throw new AuthenticationException("Check username and password");
    }

}
