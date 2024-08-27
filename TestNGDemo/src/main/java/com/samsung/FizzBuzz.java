package com.samsung;

/**
 * Hello world!
 *
 */
public class FizzBuzz
{
    public String getFizzBuzz(int number)
    {
        if(number<=0)
            throw new IllegalArgumentException("Input must be greater than 0");
        String output = "";
        for (int i = 1; i <= number; i++) {
            if(i%3!=0 && i%5!=0) output+=String.valueOf(i);
            if(i%3==0) output+="Fizz";
            if(i%5==0) output+="Buzz";

            output= i<number?output+=",": output;
        }
        return output;
    }
}
