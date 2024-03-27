package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);

    boolean findByUsername(boolean b); //added from line 35 on accountService
}
