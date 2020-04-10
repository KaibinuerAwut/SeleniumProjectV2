package com.automation.tests.Day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WarmUpTask {

    /* day12 (3/22/2020, sunday)

       Go to http://practice.cybertekschool.com/tables
       Click on “Last name” column name
       Verify that table is sorted by last name in alphabetic order.
        */
    @Test
    public void tableVerifySorted(){

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]")).click();



        BrowserUtils.wait(4);




    }


}
