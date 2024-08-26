package com.samsung;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitAnnotation {
    @Before
    public void Setup()
    {
        System.out.println("Setup");
    }

    @Test
    public void first_test()
    {
        System.out.println("First Test");
    }

    @Test
    public void second_test()
    {
        System.out.println("Second Test");
    }

    @After
    public void TearDown()
    {
        System.out.println("Tear Down");
    }
}
