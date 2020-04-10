package com.automation.tests.Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class warmUpTask {

    /*
Go to ebay:
enter search term
click on search button
print number of results

go to amazon:
enter search term
click on search button
verify title contains search term

Go to wikipedia.org
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
     */

    public static void main(String[] args) throws Exception {
        ebayTest();
        amazonTest();
        wikiTest();

    }
    public static void ebayTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult = driver.findElement(By.tagName("h1"));
        System.out.println(searchResult.getText().split(" ")[0]);

        Thread.sleep(2000);
        driver.quit();

    }
    public static void amazonTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        String title = driver.getTitle();

        Thread.sleep(2000);
        driver.quit();
        if(title.contains("java book")){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
        }
        driver.quit();
    }

    public static void wikiTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://en.wikipedia.org/wiki/main_page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium(software)", Keys.ENTER);

        String link = driver.getCurrentUrl();
        if(link.endsWith("Selenium(software)")){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
        }

        Thread.sleep(2000);
        driver.quit();
    }

}
