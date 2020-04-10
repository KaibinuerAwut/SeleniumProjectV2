package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropDown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();

        //browserUtils.wait(3);
       // driver.findElement(By.linkText("Amazon")).click(); // click on option

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for (WebElement Link : allLinks) {
            System.out.println(Link.getText() + " : " + Link.getAttribute("href"));

        }


        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Etsy")).click();  // click on option


















        BrowserUtils.wait(4);
        driver.quit();



    }
}
