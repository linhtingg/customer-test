package com.samsung.tddspringboot.repository;

import com.samsung.tddspringboot.repository.models.Account;
import org.springframework.stereotype.Repository;

import javax.naming.OperationNotSupportedException;

@Repository
public class AccountRepository {
    public Account getAccountByAccountNumber(String accNumber){
        throw new RuntimeException("Function is not implemented");
    }

    public boolean updateAccount(Account account)
    {
        throw new RuntimeException("Function is not implemented");
    }
}
