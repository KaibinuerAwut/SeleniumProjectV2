package com.automation.tests.Day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTable {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
       /*
       WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to true to make it work
        chromeOptions.setHeadless(false);   //to run browser without GUI. Makes browser invisible.
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
       }
        */

        driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(4);
    }



    @AfterMethod
    public void tearDown(){

        BrowserUtils.wait(5);
        driver.quit();
    }

    @Test
    public void getColumnNames(){
        //th-- represents table header cells
        List<String> expected = Arrays.asList("Last", "First Name", "Email", "Due", "Web Site","Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());

        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);

    }

    @Test
    public void verifyRowCount(){

        // //tbody//tr -- to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        // if we will get a size of this collection, it automatically equals to number of elements

        Assert.assertEquals(rows.size(), 4);

    }


    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){
        //td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));

    }

    /** TASK until 4:45
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */

    @Test
    public void deleteEmailByRow(){

        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);
        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

        Assert.assertTrue(emails.isEmpty());

       // Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }


    @Test
    public void getColumnIndexByName(){

        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index =0;

        for (int i = 0; i <columnNames.size() ; i++) {

            if (columnNames.get(i).getText().equals(columnName)){
                index = i+1;
                break;

            }

        }


        Assert.assertEquals(index,3);

    }

    @Test
    public void getSpecificCell(){


            String expected = "http://www.jdoe.com";

            int row = 3;
            int column = 5;

            String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";

            WebElement cell = driver.findElement(By.xpath(xpath));
            Assert.assertEquals(cell.getText(), expected);


    }



}



