package com.automation.tests.Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class jumpToNewWindow {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some ID, thi ID calls window handle
        // based on window handle, we can switch in between windows


        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("before switch: " + driver.getCurrentUrl());
       // since we have all the window, and we know ID of original window,
        // we can say switch to something that is not equals to old window ID

        for (String windowID : windowHandles) {
            if (!windowID.equals(windowHandles) ){
                driver.switchTo().window(windowID);

            }

        }
        System.out.println("after switch:" + driver.getCurrentUrl());

       // driver.close();
        driver.quit();

    }
         public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){

        Set<String> windows = driver.getWindowHandles();

             for (String window : windows) {
                 driver.switchTo().window(window);
                 if (driver.getTitle().equals(pageTitle)) {
                     break;

                 }
                 }

             }

         }


