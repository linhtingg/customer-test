package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.AccountRepository;
import com.samsung.tddspringboot.repository.models.Account;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByNumber(String accountNumber)
    {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }

    public Account getAccountByEmail(String accountEmail)
    {
        return accountRepository.getAccountByAccountEmail(accountEmail);
    }

    public String createAccount(String Number, String Email, String Name, LocalDateTime CreatedAt)
    {
        Account acc1 = accountRepository.getAccountByAccountEmail(Email);
        if(acc1!=null)
            return "Email already exists";

        if(!Number.startsWith("C"))
            return "Customer number must start with 'C'";

        Account acc2 = accountRepository.getAccountByAccountNumber(Number);
        if(acc2!=null)
            return "Customer number already exists";

        return "Successfully created account";
    }

}
