package Mock;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

public class AccountMangerTest {

    @Mock
    AccountRepository accRepository;

    AccountManager accountManager;

    @BeforeClass
    public void InitTest()
    {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeTest
    public void Setup()
    {

    }
    @Test
    public void should_return_account_does_not_exist()
    {
        String accountNumber = "0541001456123";

        //Setup mock for repository
        when(accRepository.getAccountByNumber(accountNumber)).thenReturn(null);

        //Arrange
        this.accountManager = new AccountManager(accRepository);
        //Act
        String result = this.accountManager.withDraw(accountNumber, 100000l);

        //Assertion
        Assert.assertEquals(result, "Tài khoản không tồn tại.");

    }

    @Test
    public void should_return_message_for_money_is_not_enough()
    {
        String accountNumber = "0541001456456";
        Long money = 500000l;

        //Setup mock
        Account acc = new Account();
        acc.Number = accountNumber;
        acc.Name = "Tran Huy Hung";
        acc.Money = 200000l;

        when(accRepository.getAccountByNumber("0541001456456")).thenReturn(acc);

        this.accountManager = new AccountManager(accRepository);
        String result = this.accountManager.withDraw(accountNumber, money);

        Assert.assertEquals(result, "Số dư không đủ để giao dịch.");
    }

    @Test
    public void should_return_message_and_update_new_money_for_account()
    {
        String accountNumber = "0541001456456";
        Long money = 500000l;

        //Setup mock
        Account acc = new Account();
        acc.Number = accountNumber;
        acc.Name = "Tran Huy Hung";
        acc.Money = 1000000l;

        when(accRepository.getAccountByNumber(accountNumber)).thenReturn(acc);
        when(accRepository.updateAccount(acc)).thenReturn(true);

        this.accountManager = new AccountManager(accRepository);
        String result = this.accountManager.withDraw(accountNumber, money);

        Assert.assertEquals(result, "Giao dịch thành công.");
    }
}
