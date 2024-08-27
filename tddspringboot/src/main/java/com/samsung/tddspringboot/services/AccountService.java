package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.AccountRepository;
import com.samsung.tddspringboot.repository.models.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public String withDrawMoney(String accNumber, Long amount)
    {
        Account acc = accountRepository.getAccountByAccountNumber(accNumber);
        if(acc==null)
            return "Tài khoản không hợp lệ.";

        if(acc.getMoney()< amount)
            return "Số dư không đủ để thực hiện.";

        acc.setMoney(acc.getMoney()-amount);
        if(accountRepository.updateAccount(acc))
            return "Giao dịch thành công.";

        return "Giao dịch thất bại";
    }
}
