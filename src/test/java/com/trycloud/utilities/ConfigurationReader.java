package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

//    1. Create the object of Properties class
//    We need Properties class to use methods from load(), getProperty("key")
//    it is static because we are using it in a static method
//    private because I want to cut access to other classes
private static Properties properties = new Properties();

//    To open the Properties file and load properties object only once before reading. Static block because static runs first.
    static{
        try {
//        2. Create object of FileInputStream
//        We need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("Configuration.properties");

//        3. Load the properties object using FileInputStream object
//        Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

//        Close the file after loading, if not it will take up memory.
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    This method is used to read value from configuration.properties file
//    @param keyword
//    @return --> value for the key. Returns null if key is not found.
//    driver.get(ConfigurationReader.getProperty("env"));
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}