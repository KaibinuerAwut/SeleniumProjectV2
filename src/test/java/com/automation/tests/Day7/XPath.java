package com.automation.tests.Day7;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath {
    public static String XpathUserNameLocator = "//label[text='Username']/following-sibling::input";
    public static String XpathPasswordLocator = "//label[text='Password']/following-sibling::input";
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

        BrowserUtils.wait(3);
       driver.findElement(By.xpath(XpathUserNameLocator)).sendKeys("tomsmith");
       driver.findElement(By.xpath(XpathPasswordLocator)).sendKeys("SuperSecretPassword");









       // browserUtils.wait(3);
      //  driver.quit();
    }
}
