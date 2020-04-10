package com.automation.tests.Day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class configurationReaderTest {

    @Test
    public void propertiesTest(){

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        System.out.println(browser);
        System.out.println(url);


        String http = ConfigurationReader.getProperty("http");
        System.out.println(http);

        String userName = ConfigurationReader.getProperty("userName");
        String passWord = ConfigurationReader.getProperty("passWord");

        System.out.println(userName);
        System.out.println(passWord);
    }

}
