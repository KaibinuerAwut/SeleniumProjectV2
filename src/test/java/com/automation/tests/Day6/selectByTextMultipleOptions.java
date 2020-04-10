package com.automation.tests.Day6;

import com.automation.utilities.DriverFactory;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);   // --> if its true, you can select more than one option

        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        // lets get all selected options
        List<WebElement> selectedLanguages = languageSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage : selectedLanguages) {
            System.out.println(selectedLanguage.getText());

        }

    BrowserUtils.wait(3);

        languageSelect.deselectByVisibleText("Java");  // to un-select sth.
        BrowserUtils.wait(4);
        languageSelect.deselectAll();














        BrowserUtils.wait(3);
        driver.quit();
    }

}
