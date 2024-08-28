package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.AccountRepository;
import com.samsung.tddspringboot.repository.models.Account;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {
    @Mock //Tạo một mock implementation for Repository
    private AccountRepository accountRepository;

    @InjectMocks //Inject đối tượng cần test (có sử dụng mock)
    private AccountService accountService;
    @Test
    public void should_return_invalid_customer_number()
    {
        //Arrange
        String accountNumber = "34554";
        String expected = "Customer number must start with 'C'";

        //Act
        String result = accountService.createAccount(
                accountNumber,
                "account@test.com",
                "My Account",
                LocalDateTime.now());

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_return_existed_email()
    {
        String accountNumber = "C001";
        String accountEmail = "account@test.com";
        String accountName = "My Account";
        LocalDateTime accountCreateAt= LocalDateTime.now();
        String expected = "Email already exists";

        //Create account to mock
        Account fakeAcc = Account.builder()
                .Name(accountName)
                .Number(accountNumber)
                .Email(accountEmail)
                .CreateAt(accountCreateAt).build();

        //Setup mock
        when(accountRepository.getAccountByAccountEmail(accountEmail)).thenReturn(fakeAcc);

        //Act
        String result = accountService.createAccount(accountNumber,accountEmail,accountName,accountCreateAt);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_return_existed_customer_number()
    {
        String accountNumber = "C001";
        String accountEmail = "account@test.com";
        String accountName = "My Account";
        LocalDateTime accountCreateAt= LocalDateTime.now();
        String expected = "Customer number already exists";

        //Create account to mock
        Account fakeAcc = Account.builder()
                .Name(accountName)
                .Number(accountNumber)
                .Email(accountEmail)
                .CreateAt(accountCreateAt).build();

        //Setup mock
        when(accountRepository.getAccountByAccountNumber(accountNumber)).thenReturn(fakeAcc);

        //Act
        String result = accountService.createAccount(accountNumber,accountEmail,accountName,accountCreateAt);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_return_successful_create_account()
    {
        String accountNumber = "C001";
        String accountEmail = "account@test.com";
        String accountName = "My Account";
        LocalDateTime accountCreateAt= LocalDateTime.now();
        String expected = "Successfully created account";

        when(accountRepository.getAccountByAccountNumber(accountNumber)).thenReturn(null);
        when(accountRepository.getAccountByAccountEmail(accountEmail)).thenReturn(null);

        //Act
        String result = accountService.createAccount(accountNumber,accountEmail,accountName,accountCreateAt);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
