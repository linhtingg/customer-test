package com.samsung.tddspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @PostMapping("/withdraw")
    public String withDrawMoney(String accountNumber, Long amount)
    {
        return "success";
    }
}
