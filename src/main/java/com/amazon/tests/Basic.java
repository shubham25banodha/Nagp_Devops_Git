package com.amazon.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;

import java.io.IOException;

public class Basic {

    WebDriver driver = null;
    WebDriverWait wait=null;

    @BeforeMethod
    public void setupTest(){
        String path = System.getProperty("user.dir");
        path = path + "\\drivers\\chromedriver_90\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,20);

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
    }

    @Test
    public void search()  {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-logo-sprites']")));

//            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='hm-icon-label']")).getText(),"All1","Icon Label are not same");

            Assert.assertEquals(driver.findElement(By.xpath("//span[@class='hm-icon-label']")).getText(),"All1");

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("one pluse9");

            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        }
        catch(AssertionError e){
            screenshot(driver,"File.jpg");
        }
    }

    @AfterMethod
    public void finishTest(){
        driver.close();
    }

    public void screenshot(WebDriver driver, String fileName)  {
        try{
            TakesScreenshot screenshot = ((TakesScreenshot)driver);

            File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);

            String fileWithPath = System.getProperty("user.dir")+"\\screenshot\\"+fileName;

            File DestFile=new File(fileWithPath);

            FileUtils.copyFile(SrcFile, DestFile);
        }
        catch(Exception e){

        }
    }
}
