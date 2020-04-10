package com.automation.SelfPractice;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class herokuapp {


   RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.createADriver("chrome");

    @BeforeMethod
    public void setup() {
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(4);
    }


   @Test(description = "basic test automation")

   public void scrollDown(){

       List<WebElement> links = driver.findElements(By.tagName("li"));
       driver.executeScript("arguments[0].scrollIntoView(true)", links.get(14));

   }














    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(4);
        driver.quit();
    }


}
