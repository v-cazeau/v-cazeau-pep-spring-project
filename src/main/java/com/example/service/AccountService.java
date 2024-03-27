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

    // private List<Account> accounts = new ArrayList<>();
    // private MessageService messageService;

    // @Autowired
    // public AccountService (MessageService messageService) {
    //     this.messageService = messageService;
    // }

    @Autowired
    private AccountRepository accountRepository;

    // #1 process new User registrations.
    // public Account register(Account newAccount) throws ResourceNotFoundException, Exception {
    //    if(newAccount.getUsername().isBlank() || newAccount.getPassword().length() < 4) {
    //     throw new ResourceNotFoundException("Invalid username or password");
    //    }
    //    if (accountRepository.findByUsername(newAccount.getUsername() != null)) {
    //     throw new Exception("Username already exists");
    //    }
    //    return accountRepository.save(newAccount);
    //    }
    // }

//    //#2 process User logins.
//     public void login(String username, String password) throws AuthenticationException {
//         for (Account account:accounts) {
//             if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
//                 return;
//             };
//         }
//         throw new AuthenticationException("Check username and password");
//     }

}
