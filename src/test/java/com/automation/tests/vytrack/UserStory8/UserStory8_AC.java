package com.automation.tests.vytrack.UserStory8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserStory8_AC {

    RemoteWebDriver driver = (RemoteWebDriver) DriverFactory.createADriver("chrome");
    private String URL = "https://qa2.vytrack.com/user/login";

    @Test
    public void loginTest() {
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager132");
        driver.findElement(By.id("prependedInput2")).sendKeys("User123User123");
        driver.findElement(By.id("_submit")).submit();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("")));


    }

















    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();


    }



}








