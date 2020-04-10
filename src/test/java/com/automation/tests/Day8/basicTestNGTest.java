package com.automation.tests.Day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class basicTestNGTest {



    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");

    }

    // runs only once in the class before @beforeMethod abd before any test
    // regardless on number of tests, it runs only once

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }


    // runs before every test automatically
    // works as a pre-condition or setup
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");

    }

    @Test
       public void test1(){
        System.out.println("Test #1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);

    }

    @Test
       public void test2(){
        System.out.println("Test #2");
        int num1 = 5;
        int num2 = 10;

        // it called as hard assertion
        // if assertion fails, it stops the execution(duo to exception)
        Assert.assertTrue(num1<num2);

       }

}
