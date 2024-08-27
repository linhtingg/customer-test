package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.repository.models.Account;
import com.samsung.tddspringboot.services.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountAPIControllerTest {
    @InjectMocks
    AccountAPIController accountAPI;

    @Mock
    AccountService accountService;

    @Test
    public void should_return_account_info_in_json_format()
    {
        Account fakeAccount = Account.builder().Name("Admin").Number("0541001542123").Money(1000000l).build();
        when(accountService.getAccount("0541001542123")).thenReturn(fakeAccount);

        ResponseEntity response = accountAPI.getAccount("0541001542123");

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        Account result = (Account)response.getBody();

        //assertThat(result).isSameAs(fakeAccount);
        assertThat(result.getName()).isEqualTo("Admin");
        assertThat(result.getNumber()).isEqualTo("0541001542123");
        assertThat(result.getMoney()).isEqualTo(1000000l);

    }
}
