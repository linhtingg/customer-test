package com.samsung;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DrawMoneyTest {
    WithDrawMoney withDrawMoney;
    @BeforeTest
    public void setup(){
        this.withDrawMoney = new WithDrawMoney();
    }
    @DataProvider(name = "invalid-data-provider")
    public Object[][] invalidDataProvider()
    {
        Object[][] data = new Object[3][1];
        data[0][0] = "HHH123";
        data[1][0] = "ABC240826";
        data[2][0] = "ABC240827";

        return data;
    }
    @Test(dataProvider = "invalid-data-provider")
    public void should_throw_exception_with_invalid_withdraw_code(String withDrawCode)
    {
        Assert.assertThrows(IllegalArgumentException.class, ()->withDrawMoney.withDraw(withDrawCode,10l));
    }

    @Test
    public void should_return_successful_message_with_valid_drawcode_and_money()
    {
        //Arrange
        String validWithDrawCode = "HYN240827";
        long validMoney = 200000;
        String expeced = "Giao dịch thành công";

        //Act
        String msg = withDrawMoney.withDraw(validWithDrawCode, validMoney);

        //Assert
        Assert.assertEquals(msg, expeced);
    }

    @Test
    public void should_return_unsuccessful_message_with_valid_drawcode_and_invalid_money()
    {
        //Arrange
        String validWithDrawCode = "HYN240827";
        long validMoney = 2000000;
        String expeced = "Giao dịch không thành công";

        //Act
        String msg = withDrawMoney.withDraw(validWithDrawCode, validMoney);

        //Assert
        Assert.assertEquals(msg, expeced);
    }
    @Test
    public void should_return_generated_date_from_withDraw_code()
    {
        //Arrange
        String account = "ABC240827";
        String expected = "240827";
        //Act
        String result = withDrawMoney.getGeneratedDate(account);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void should_return_today_date_in_string()
    {
        String result = withDrawMoney.getTodayDateInString();
        Assert.assertEquals("240827", result);
    }
}
