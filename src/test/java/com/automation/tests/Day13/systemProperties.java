package com.automation.tests.Day13;

import org.testng.annotations.Test;

public class systemProperties {



    @Test
    public void test(){


        System.out.println(System.getProperty("user.dir"));  //  /Users/qalbi/IdeaProjects/mySeleniumProject
        System.out.println(System.getProperty("java.home"));  //  /Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home
        System.out.println(System.getProperty("java.version")); // 13.0.1
        System.out.println(System.getProperty("os.name"));  // Mac OS X
        System.out.println(System.getProperty("os.version")); // 10.15.2
        System.out.println(System.getProperty("user.home"));  // /Users/qalbi
        System.out.println(System.getProperty("os.arch"));  //x86_64

        String pathToDownLoads = System.getProperty("user.home") + "Downloads";
        System.out.println(pathToDownLoads);  ///Users/qalbiDownloads







    }
}
