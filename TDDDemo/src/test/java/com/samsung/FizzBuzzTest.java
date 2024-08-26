package com.samsung;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
    public FizzBuzz fizzBuzz;
    @Before
    public void Setup()
    {
        fizzBuzz = new FizzBuzz();
    }

    @Test(expected = IllegalArgumentException.class) //JUnit - assert exception
    public void Should_Return_Exception_with_invalid_argument()
    {
        fizzBuzz.getFizzBuzz(0); //Call function throw exception
        fizzBuzz.getFizzBuzz(-1);
    }

    @Test
    public void Should_Return_Fizz_With_Number_Multiple_Of_3()
    {
        //Arrange
        int number = 4;
        String expected = "1,2,Fizz,4";

        //Act
        String result = fizzBuzz.getFizzBuzz(number);

        //Assertion
        Assert.assertEquals(expected, result);
    }

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
}
