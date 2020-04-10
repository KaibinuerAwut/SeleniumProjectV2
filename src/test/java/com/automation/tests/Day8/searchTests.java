package com.automation.tests.Day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class searchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them

        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            String var = searchItem.getText();
            //if there is a text - print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    /*
    Given user is on the amazon.com page
    when user inters "java" as a search item
    then user clicks on the search button
    and user clicks on the first search item
    and user verifies that title of the search item contains "java"

     */
    @Test(description = "search for java book on amazon")

    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        driver.manage().window().maximize();
        BrowserUtils.wait(6);

        List<WebElement> searchItems = driver.findElements(By.tagName("//h2//a"));

        // click on first item
        searchItems.get(0).click();
        BrowserUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

       Assert.assertTrue(productTitleString.contains("Java"));

    }

    @BeforeMethod
    public void setup(){
        //setup WebDriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy WebDriver object
        driver.quit();
    }



}
