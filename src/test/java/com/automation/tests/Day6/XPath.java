package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);

        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

        // click on button #2
        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button2']"));
        btn2.click();






        BrowserUtils.wait(4);
        driver.quit();

    }
}
