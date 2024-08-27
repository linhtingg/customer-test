package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.repository.models.Account;
import com.samsung.tddspringboot.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String sayHello(final Model model)
    {
        model.addAttribute("name", "Khanh Tran");
        return "Hello";
    }

    @PostMapping("/withdraw")
    public String withDrawMoney(Account account, final Model model)
    {
        String str =accountService.withDrawMoney(account.getNumber(), account.getMoney());
        model.addAttribute("msg", str);
        return "withDrawResult";
    }
}
