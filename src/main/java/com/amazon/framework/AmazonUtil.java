package com.amazon.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AmazonUtil {
    public Properties configProps=null;
    FileInputStream file = null;

    //code to read config file
    public void readConfig(){
        configProps=new Properties();
        try {
            String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\";
            file =new FileInputStream(filePath+"config.properties");
            configProps.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // code to read lcator file
    public Properties readLocators(String locatorFileName) throws IOException {
        Properties locatorProps=new Properties();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\Locators\\";
        FileInputStream file = new FileInputStream(filePath+locatorFileName);

        locatorProps.load(file);

        return locatorProps;
    }

    //code to read testdata file
    public Properties readTestData(String testdataFileName) throws IOException {
        Properties locatorProps=new Properties();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\";
        FileInputStream file = new FileInputStream(filePath+testdataFileName);

        locatorProps.load(file);

        return locatorProps;
    }


//    public int randomNumber(int max,int min){
//        return (int)(Math.random()*(max-min+1)+min);
//    }

}
