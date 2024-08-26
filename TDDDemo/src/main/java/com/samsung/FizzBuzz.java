package com.samsung;

public class FizzBuzz {
    public String getFizzBuzz(int input)
    {
        if(input<=0)
            throw new IllegalArgumentException("Input must be greater than 0");
        String output = "";
        for (int i = 1; i <= input; i++) {
            if(i%3==0 && i%5==0)
                output+=",FizzBuzz";
            else if(i%3==0)
                output+=",Fizz";
            else if(i%5==0)
                output+=",Buzz";
            else
                output+= output==""? ""+i:","+i;
        }
        return output;
    }
}
