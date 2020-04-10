package com.automation.tests.Day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class checkBoxesTest {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        // ## task
        // verify that first checkbox is not selected and second one is selected
        BrowserUtils.wait(5);
        //<input type="checkbox" checked="">

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");

        }
        BrowserUtils.wait(2);
        // lets click on the first checkbox and verify its clicked
      //  checkBoxes.get(0).click();

        WebElement checkBox1 =  checkBoxes.get(0);
        checkBox1.click();

        if (checkBox1.isSelected()){
            System.out.println("test passed");
            System.out.println("checkbox #1 is selected");

        }  else {
            System.out.println("test failed");
            System.out.println("checkbox #1 is not selected");
        }

        driver.quit();
    }
}