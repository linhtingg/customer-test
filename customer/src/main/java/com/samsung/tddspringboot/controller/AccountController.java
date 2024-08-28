package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.repository.AccountRepository;
import com.samsung.tddspringboot.repository.models.Account;
import com.samsung.tddspringboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
public class AccountController {
    private final AccountRepository accountRepository;
    AccountService accountService;
    public AccountController(AccountService accountService, AccountRepository accountRepository)
    {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/")
    public String sayHello(final Model model)
    {
        model.addAttribute("name", "Khanh Tran");
        return "Hello";
    }
//
//    @PostMapping
//    public ResponseEntity<Account> createCustomer(@RequestBody Account account) {
//        Account createdAccount = accountService.createAccount(account);
//        return ResponseEntity.created(URI.create("/customers/" + createdAccount.getNumber())).body(createdAccount);
//
//    }

//    @GetMapping
//    public ResponseEntity<List<Account>> getAllCustomers() {
//        List<Account> accounts = accountRepository.findAll();
//        return ResponseEntity.ok(accounts);
//    }

}
