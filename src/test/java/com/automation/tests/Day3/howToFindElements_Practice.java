package com.automation.tests.Day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class howToFindElements_Practice {
    public static void main(String[] args) throws Exception{

       // WebDriverManager.chromedriver().setup();
      //  WebDriver driver = new ChromeDriver();
        // instead of creating webdriver everytime, we can create the method will give us the webdriver;

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

       // driver.findElement(By.name("full_name")).sendKeys("Kalbinur Abidt");
       // driver.findElement(By.name("email")).sendKeys("k.abidt@gmail.com");
       // driver.findElement(By.className("selenium")).submit();

        Thread.sleep(2000);

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Kalbinur Abidt");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("k.abidt@gmail.com");

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("abc123"));
        signUp.submit();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText();

        if (expected.equals(actual)){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed");
        }



        driver.quit();



    }


}
