package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.repository.models.Account;
import com.samsung.tddspringboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAPIController {
    @Autowired
    AccountService accountService;
    @GetMapping("/api/account/{accountNumber}")
    public ResponseEntity getAccount(@PathVariable("accountNumber") String accountNumber)
    {
        Account acc = accountService.getAccount(accountNumber);
        return ResponseEntity.ok(acc);
    }
}
