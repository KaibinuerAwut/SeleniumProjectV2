package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JavascriptAlerts_popupMessage {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click();   // to click on the first button
        BrowserUtils.wait(3);


        String popupText = driver.switchTo().alert().getText();  // to get the text from popup message
        System.out.println(popupText);

        driver.switchTo().alert().accept();  // to click ok

        String expected = "you successfully clicked an alert.";
        String actual = driver.findElement(By.id("result")).getText();

        // if its failed, it means there is a bug
        System.out.println("Test #1");

        if (expected.equals(actual)){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        BrowserUtils.wait(3);

        System.out.println("Test #2");
        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss(); // result must be: You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected2);
            System.out.println("Actual:   "+actual2);
        }

        System.out.println("Test #3");

        //TASK for 5 minutes until 3:37: click on button #3
        //Enter some text: Hello, World!
        //Verify that result text ends with Hello, World!
        buttons.get(2).click();

        BrowserUtils.wait(3);

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World!");//enter text
        alert.accept();// click ok

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";

        if(actual3.endsWith(expected3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected3);
            System.out.println("Actual:   "+actual3);
        }



        BrowserUtils.wait(4);
        //driver.quit();


    }



}
