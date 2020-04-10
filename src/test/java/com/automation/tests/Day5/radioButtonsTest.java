package com.automation.tests.Day5;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class radioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        // if visible and eligible to click
        if (blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("click on black button");

            blackButton.click();
        } else {
            System.out.println("failed to click black button");
        }
        // how do we verify that button clocked
        // return true , if button is clicked

        if (blackButton.isSelected()){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed");


        }
        driver.quit();
    }


}
