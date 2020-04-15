package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class AbstractTestBase {

    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    protected static int row = 1;
    protected ExcelUtil excelUtil;

    //@Optional - to make parameter optional
    //if you don't specify it, testng will require to specify this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setUpTest(@Optional String reportName){
        System.out.println("Report name: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";

        report =new ExtentReports();

        String reportPath = "";
       // location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")){
            reportPath = System.getProperty("user.dir")+ "/test-output/" + reportName;

        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        }
        //is a HTML itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        // add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Vytrack Test Automation Result");

    }

    @AfterTest
    public void tearDownTest(){
        report.flush(); // to release a report



    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        //no failure - no screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath, "Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output
            //if excelUtil object was created
            //set value if result column to failed

            if (excelUtil != null) {
                excelUtil.setCellData("FAILED", "result", row++);
            }

        }
        Driver.closeDriver();
    }
}



