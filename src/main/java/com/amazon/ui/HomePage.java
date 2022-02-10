package com.amazon.ui;

import com.amazon.framework.Base;
import com.amazon.framework.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;


public class HomePage extends Base {
    WebElement webElement;
    public static String homeTestCaseName;

    private static Properties locatorProps=null;
    private static Properties testDataProps=null;

    // Initialize locators and test data files
    public void preStepHomePage() throws IOException {
        readConfig();

        locatorProps = readLocators("homePage.locators");
        testDataProps = readTestData("homePageTestdata.properties");

        setupTest();
    }

    // Launch amazon page
    public void launchHomePage(){
        launchHomePage(configProps.getProperty("URL"));
    }

    // Validate home page title
    public void validateHomePageTitle() throws InterruptedException {
        Reporting.failMessage = homeTestCaseName+"_ValidateHomePageTitle";
        Reporting.test = Reporting.extent.createTest(homeTestCaseName);
        validatePageTitle(configProps.getProperty("PageTitle"));
        Reporting.logPass("HomePage Tile Validated Successfully");
    }

    //Perform Search
    public void search(){
        Reporting.failMessage = homeTestCaseName+"_EnterSearchTerm";
        enterTextField(locatorProps.getProperty("SearchBox"),testDataProps.getProperty("searchTerm"));
        Reporting.failMessage = homeTestCaseName+"_ClickSearchButton";
        clickOnElement(locatorProps.getProperty("SearchButton"));
        Reporting.logPass("User has Successfully entered search term and clicked on search button");
    }

    //Validate Page title
    public void validateResultPage(){
        Reporting.failMessage = homeTestCaseName+"_ValidatePageTitle";
        switch (homeTestCaseName.toLowerCase()){
            case "search":
                validatePageTitle(testDataProps.getProperty("SearchResultPageTitle")+" "+testDataProps.getProperty("searchTerm"));
                break;
            case "about_us":
                System.out.println("*******"+testDataProps.getProperty("AboutUsPageTitle"));
                validatePageTitle(testDataProps.getProperty("AboutUsPageTitle"));
                break;
        }
        Reporting.logPass("Result Page Title Validated Successfully");

    }

    //Close browser
    public void exitStepHomePage(){
        closeBrowser();
    }

    //Navigate to About_Us page
    public void navigateAboutUs(){
        Reporting.failMessage = homeTestCaseName+"_NavigateToAboutUsPage";
        clickOnElement(locatorProps.getProperty("AboutUs"));
        waitForElement(locatorProps.getProperty("AboutUsSocialLink"));
        Reporting.logPass("User navigated to About Us page");
    }

    //Navigate to different Tabs present on homepage
    public void navigateTab(){
        String tempTabxPath ;
        for(int i=0;i<14;i++){
            Reporting.failMessage = homeTestCaseName+"_failed to navigate on Tab";
            tempTabxPath = locatorProps.getProperty("Tab").replace("@@@@",Integer.toString(i));
            if(i!=2){
                waitForElement(tempTabxPath);
                clickOnElement(tempTabxPath);
            }
            else { clickOnElement(locatorProps.getProperty("AmazonPrimeTab"));}
            validatePageTitle(testDataProps.getProperty("Tab"+i+"PageTitle"));
            Reporting.logPass("User successfully navigated to tab :- "+testDataProps.getProperty("Tab"+i+"PageTitle"));
        }
        Reporting.logPass("User successfully navigated to all tab in homepage");
    }

}
