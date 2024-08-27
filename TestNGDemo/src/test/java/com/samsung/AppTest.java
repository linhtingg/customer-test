package com.samsung;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    FizzBuzz fizzBuzz;
    @BeforeTest
    public void Setup()
    {
        this.fizzBuzz = new FizzBuzz();
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void should_throw_exception_with_negative_input()
    {
        Assert.assertThrows(IllegalArgumentException.class, ()->fizzBuzz.getFizzBuzz(0));
    }

    @Test(dataProvider = "fizzbuzz-dataprovider")
    public void should_regturn_correct_fizz_buzz_follow_input(int number, String expected)
    {
        //Act
        String result = fizzBuzz.getFizzBuzz(number);

        //Assertion
        Assert.assertEquals(expected, result);
    }

    @DataProvider(name = "fizzbuzz-dataprovider")
    public Object[][] fizzBuzzData()
    {
        Object[][] data = new Object[3][2];
        data[0][0] = 3;
        data[0][1] = "1,2,Fizz";

        data[1][0] = 5;
        data[1][1] = "1,2,Fizz,4,Buzz";

        data[2][0] =6;
        data[2][1] = "1,2,Fizz,4,Buzz,Fizz";
        return data;
    }

    /*
    @Test
    public void Should_return_Buzz_with_Multiple_number_of_5()
    {
        //Arrange
        int number = 6;
        String expected = "1,2,Fizz,4,Buzz,Fizz";

        //Act
        String result = fizzBuzz.getFizzBuzz(number);

        //Assertion
        Assert.assertEquals(expected,result);
    }

    @Test
    public void Should_return_FizzBuzz_with_multiple_number_of_3_and_5()
    {
        //Arrange
        int number = 15;
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";

        //Act
        String result = fizzBuzz.getFizzBuzz(number);

        //Assertion
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_return_FizzBuzz_with_random_number()
    {
        //Arrange
        int number = 20;
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz";

        //Act
        String result = fizzBuzz.getFizzBuzz(number);

        //Assertion
        Assert.assertEquals(expected, result);
    }
     */
}
