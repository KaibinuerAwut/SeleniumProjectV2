package com.automation.tests.Day3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElementByID {

    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();


        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        // lets click on logout button. it looks like a button, but its actually a link
        // every element with <a> tag is a link
        // if you have couple spaces in the text, just use partialLinkText instead of linkedText
        // linkedText - equals()
        // partialLinkedText - contains() - complete match doesn't required
        // don't put space

        WebElement logout = driver.findElement(By.partialLinkText("logout"));

        String href = logout.getAttribute("href");
        String classname = logout.getAttribute("class");
        System.out.println(href);
        System.out.println(classname);

        logout.click();
        Thread.sleep(2000);

        driver.quit();

    }


}
