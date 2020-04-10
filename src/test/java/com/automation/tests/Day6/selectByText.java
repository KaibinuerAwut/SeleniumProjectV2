package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectByText {

    public static void main(String[] args) {

            WebDriver driver = DriverFactory.createADriver("chrome");
            driver.get("http://practice.cybertekschool.com/dropdown");
            BrowserUtils.wait(3);
            //create a webelement object for drop-down first
            WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
            //provide weblement object into constructor
            Select selectSimpleDropdown = new Select(simpleDropdown);
            //select by visible text
            selectSimpleDropdown.selectByVisibleText("Option 2");
            BrowserUtils.wait(3);
            //and select option 1
            selectSimpleDropdown.selectByVisibleText("Option 1");

            //select you DOB
            Select selectYear = new Select(driver.findElement(By.id("year")));
            Select selectMonth = new Select(driver.findElement(By.id("month")));
            Select selectDay = new Select(driver.findElement(By.id("day")));

            selectYear.selectByVisibleText("1990");
            selectMonth.selectByVisibleText("July");
            selectDay.selectByVisibleText("14");

            BrowserUtils.wait(5);

            //select all months one by one
            //.getOptions(); - returns all options from dropdown as List<WebElement>
            List<WebElement> months = selectMonth.getOptions();
            for(WebElement eachMonth: months){
                //get the month name and select based on that
                String monthName = eachMonth.getText();
                selectMonth.selectByVisibleText(monthName);
                BrowserUtils.wait(1);
            }

        BrowserUtils.wait(5);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Wisconsin");

        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText() method
        // getText() retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption: states){
            System.out.println(stateOption.getText());
        }


        BrowserUtils.wait(3);
            driver.quit();
        }
    }

