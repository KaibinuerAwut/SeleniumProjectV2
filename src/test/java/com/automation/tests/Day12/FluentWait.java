package com.automation.tests.Day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWait {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createADriver("chrome");


    }

    @Test
    public void fluentWaitTest(){










    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }



}
