package com.automation.tests.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class basicNavigation {

    public static void main(String[] args) throws Exception {

//  to start selenium script we need:
        // setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();

       // RemoteWebDriver driver1 = new ChromeDriver();
       // RemoteWebDriver driver2 = new SafariDriver();
       // RemoteWebDriver Driver3 = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        // in selenium, everything starts from Webdriver interface
        // ChromeDriver extends RemoteWebdriver --> implements webdriver
        driver.get("http://google.com"); // to open a website
        driver.manage().window().maximize(); // to maximize the browser
         Thread.sleep(3000);

// method returns page title, we can also see it as tab name in the browser
         String title = driver.getTitle();
         String expectedTitle = "Google";
        System.out.println("title is " +  title);

        if (expectedTitle.equals(title)){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
        }

       // go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed!");
        } else {
            System.out.println("test failed!");
        }

       // come back to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");

        // move forward in the browser history --> it means that browser going back to amazon
        driver.navigate().forward();
        System.out.println("title: " + driver.getTitle());
        // driver getTitle() - returns page title of the page that is currently opened

         driver.navigate().refresh();// reload the page

       //driver.navigate().to() = driver.get();


     // must be at the end
         driver.close(); // to close browser
        // browser cannot close itself
    }
     public static void verifyEquals(String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("test passed!");

        } else {
            System.out.println("test failed!");
        }

     }


}
