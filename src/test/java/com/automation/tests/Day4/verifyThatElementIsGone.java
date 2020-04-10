package com.automation.tests.Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class verifyThatElementIsGone {

        /**
         * Interview question:
         *
         * how to check if element doesn't exists any more in th DOM (Document Object Model (that HTML code))
         *
         */

        public static void main(String[] args) throws Exception{

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/multiple_buttons");
            Thread.sleep(2000);

           driver.findElement(By.id("disappearing_button")).click();
           Thread.sleep(2000);

            List<WebElement> list = driver.findElements(By.id("disappearing_button"));

            // if size is 0, it means that no elements were found

            if(list.size() == 0){
                System.out.println("TEST PASSED");
            }else {
                System.out.println("TEST FAILED");
            }

            Thread.sleep(2000);

            // to find all buttons
            // make sure that let us findElements <--- ending is important

            List<WebElement> buttons = driver.findElements(By.tagName("button"));

            for (WebElement button : buttons){
                // click on every button
                button.click();
                Thread.sleep(2000);

                }

            driver.quit();

         }

     }
