package com.automation.tests.Day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

private WebDriver driver;
private Actions actions;

// action class
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //build() is needed when you have couple of actions
        //always end with perform()
        // pause(1000). - like Thread.sleep(1000)

        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
         BrowserUtils.wait(4);

        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible

        actions.moveToElement(img1).perform();
        WebElement img1Text = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webElement that contains the text is visible
        Assert.assertTrue(img1Text.isDisplayed());

        //move to the second image
        BrowserUtils.wait(3);

        actions.moveToElement(img2).perform();
        WebElement img2Text = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(img2Text.isDisplayed());

        // move to the third image
        BrowserUtils.wait(3);

        actions.moveToElement(img3).perform();
        WebElement img3Text = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(img3Text.isDisplayed());

    }

    @Test
    public void JQueryUI_Menu_Test(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");


        //TODO: hover on "enabled", hover on "downloads", and click on PDF

        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        //WebElement backToJquery = driver.findElement(By.id(" ui-id-8"));
       // WebElement csv = driver.findElement(By.id("ui-id-6"));
      // WebElement excel = driver.findElement(By.id("ui-id-7"));

         actions.moveToElement(enabled).
              pause(1000).
              moveToElement(downloads).
               pause(1000).
                click(pdf).
              build().perform();

       // TODO: hover on "enabled", hover on "downloads", and click on CSV
    /*
      actions.moveToElement(enabled).
              pause(1000).
              moveToElement(csv).
              pause(1000).
              click(csv).
              build().perform();

     */

    }
@Test
public void dragAndDropDownTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(4);

        //click on accept cookies
       driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
       BrowserUtils.wait(3);

       // click on cookie setting and save settings
      // driver.findElement(By.xpath("//button[@class='optanon-toggle-display cookie-settings-button']")).click();
      // driver.findElement(By.xpath("//button[contains(text(),'Save Settings')]")).click();

       BrowserUtils.wait(3);

       WebElement earth = driver.findElement(By.id("droptarget"));
       WebElement moon = driver.findElement(By.id("draggable"));

       actions.dragAndDrop(moon,earth).perform();

       String expected = "You did great!";
       String actual = earth.getText();

       Assert.assertEquals(actual, expected);




}




























    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createADriver("chrome");
        actions=new Actions(driver);

    }

@AfterMethod
    public void tearDown(){
    BrowserUtils.wait(4);
    driver.quit();

   }

}
