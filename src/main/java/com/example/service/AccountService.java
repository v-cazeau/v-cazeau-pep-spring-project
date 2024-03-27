package com.example.service;

import com.example.entity.Account;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.naming.AuthenticationException;

@Service
public class AccountService {

    public AccountRepository accountRepository;

    @Autowired
    public AccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // #1 process new User registrations.
    public Account register(Account newAccount)  {
       if(newAccount.getUsername().isBlank() || newAccount.getPassword().length() < 4) {
        return null;
       }
       return accountRepository.save(newAccount);
    
    }

    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username); 
    }

//    //#2 process User logins.
    public Account login(Account account) {
            Account login = accountRepository.findAccountByUsername(account.getUsername());
            if(login != null && login.getPassword().equals(account.getPassword())) {
                return account;
            } 
            return null;
    }

}
