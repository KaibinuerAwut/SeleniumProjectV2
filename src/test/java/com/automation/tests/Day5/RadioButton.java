package com.automation.tests.Day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        BrowserUtils.wait(2);
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton: radioButtons) {
            String id = radioButton.getAttribute("id");

            // boolean
            // to check if button can be clicked
            if (radioButton.isEnabled()) {

                radioButton.click();
                System.out.println("click on : " +  id);
                BrowserUtils.wait(2);

            } else {
                System.out.println("button is disabled, not clicked!" +  id);


            }

            System.out.println();
        }


           driver.quit();



    }

}
