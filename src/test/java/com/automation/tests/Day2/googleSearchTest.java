package com.automation.tests.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://gooogle.com");
        Thread.sleep(5000);

        // By.name("q") --> name = "q"
        // name - its one of the selenium locators
        // there are 8 locators
        // we use locators to find elements
        // to choose locator, just use By.locator

        WebElement search = driver.findElement(By.name("q"));

       // once we found and element, how to enter text?
        // to enter text, use sendKeys() method
        // how to press enter after entering the text?
        // use Key.Enter
        // Key.Enter - perform keyboard click

        search.sendKeys("java", Keys.ENTER);
        // 2000 - 2 seconds
        // 12000 - 12 seconds
        //Thread.sleep() - is used to pause java program
        Thread.sleep(4000);


        //if see <a> element, it calls link
        //visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();//to click on the element
        Thread.sleep(4000);

        driver.quit();



    }

}
