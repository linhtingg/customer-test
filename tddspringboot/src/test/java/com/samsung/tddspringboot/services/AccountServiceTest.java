package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.AccountRepository;
import com.samsung.tddspringboot.repository.models.Account;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {
    @Mock //Tạo một mock implementation for Repository
    private AccountRepository accountRepository;

    @InjectMocks //Inject đối tượng cần test (có sử dụng mock)
    private AccountService accountService;
    @Test
    public void should_return_account_does_not_exist_with_invalid_account()
    {
        //Arrange
        String accountNumber = "0541001456123";
        String expected = "Tài khoản không hợp lệ.";

        //Setup mock
        when(accountRepository.getAccountByAccountNumber(accountNumber)).thenReturn(null);

        //Act
        String result = accountService.withDrawMoney(accountNumber, 100000l);

        //Assert
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void should_return_money_is_not_enough_message()
    {
        String accountNumber = "0541001456123";
        Long amount = 500000l;
        String expected = "Số dư không đủ để thực hiện.";

        //Create account to mock
        Account fakeAcc = Account.builder()
                .Name("My Account")
                .Number(accountNumber)
                .Money(200000l).build();

        when(accountRepository.getAccountByAccountNumber(accountNumber)).thenReturn(fakeAcc);

        //Act
        String result = accountService.withDrawMoney(accountNumber, amount);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void should_return_successful_transaction_with_draw()
    {
        String accountNumber = "0541001456123";
        Long amount = 500000l;
        String expected = "Giao dịch thành công.";

        //Create account to mock
        Account fakeAcc = Account.builder()
                .Name("My Account")
                .Number(accountNumber)
                .Money(2000000l).build();

        when(accountRepository.getAccountByAccountNumber(accountNumber)).thenReturn(fakeAcc);
        when(accountRepository.updateAccount(fakeAcc)).thenReturn(true);
        //Act
        String result = accountService.withDrawMoney(accountNumber, amount);

        //Assert
        assertThat(result).isEqualTo(expected);
        assertThat(fakeAcc.getMoney()).isEqualTo(1500000l);
    }
}
