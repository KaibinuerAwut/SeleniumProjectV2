package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {


     private static Properties configFile;

        static {
            try {

                // location of properties file
                String path = System.getProperty("user.dir")+"/configuration.properties";
                // get that file as a stream
                FileInputStream input = new FileInputStream(path); // path -> to get the file
              // create object of properties class
                configFile = new Properties();
             // load properties file into properties object
                configFile.load(input);
                // close the stream at the end
                input.close();

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file!");
            }
        }

        public static String getProperty(String keyName) {
            return configFile.getProperty(keyName);

        }

   }




