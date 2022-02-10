package com.amazon.framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class Base extends AmazonUtil {
    public static WebDriver driver = null;
    public static WebDriverWait wait=null;


    WebElement element = null;
    public String testCaseName="";

    //Initialize webdriver on basis of config properties file
    public void setupTest(){
        String path = System.getProperty("user.dir");
        String browserName = configProps.getProperty("browser");

        switch (browserName){
            case "chrome":
                path = path + "\\drivers\\chromedriver_97\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                path = path + "\\drivers\\geckoDriver_029\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver",path);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "IE":
                path = path + "\\drivers\\IE32bitDriver\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", path);
                driver=new InternetExplorerDriver();
                break;
            default:
                break;
        }
        wait = new WebDriverWait(driver,Integer.parseInt(configProps.getProperty("waitTimeoutInSeconds")));
        wait = new WebDriverWait(driver,10);
    }

    //Launch homepage
    public void launchHomePage(String URL){
        driver.get(URL);
    }

    //close browser
    public void closeBrowser(){
        driver.close();
    }

    //return page title
    public String pageTitle(){
        return driver.getTitle();
    }

    //validate title of any page
    public void validatePageTitle(String expectedText){
        Assert.assertEquals(pageTitle(),expectedText);
    }

    //assertion
    public void bAssertion(String expectedText, String ActualText){
        Assert.assertEquals(ActualText,expectedText);
    }

    //code to capture screenshot of application
    public static void screenshot(String fileName)  {
        String fileWithPath=null;
        File DestFile =null;
        try{
            TakesScreenshot screenshot = ((TakesScreenshot)driver);

            File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);

//            fileWithPath = System.getProperty("user.dir")+"\\Current_Report\\"+fileName;
            fileWithPath = fileName;

            DestFile=new File(fileWithPath);

            FileUtils.copyFile(SrcFile, DestFile);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //code to return webelement
    public static WebElement getElementByxPath(String xPath) {
        waitForElement(xPath);
        WebElement element = driver.findElement(By.xpath(xPath));
        return element;
    }

    //get test of any xpath
    public static String bGetText(String xPath){
        return getElementByxPath(xPath).getText();
    }

    //wait for element untill its visibility
    public static void waitForElement(String xPath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    //enter details in any text field
    public void enterTextField(String textFieldxpath,String text){
        getElementByxPath(textFieldxpath).sendKeys(text);
    }

    //click on any web element
    public void clickOnElement(String elementxPath){
        getElementByxPath(elementxPath).click();
    }



}
