package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class selectByValue {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(4);

        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByValue("CA");
        String expectedResult = "California";
        String actualResult = stateSelect.getFirstSelectedOption().getText();

        if(expectedResult.equals(actualResult)){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
        }



        BrowserUtils.wait(3);
        driver.quit();

    }
}