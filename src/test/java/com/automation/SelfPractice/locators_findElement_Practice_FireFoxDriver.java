package com.automation.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locators_findElement_Practice_FireFoxDriver {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://formy-project.herokuapp.com/form");


        driver.findElement(By.id("first-name")).sendKeys("Qalbinour");
        driver.findElement(By.id("last-name")).sendKeys("Abidt");
        driver.findElement(By.id("job-title")).sendKeys("Developer");









    }
}
