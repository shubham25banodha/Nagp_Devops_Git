package com.amazon.ui;

import com.amazon.framework.Base;
import com.amazon.framework.Reporting;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;


public class HamburgerMenuPage extends Base {
    WebElement webElement;
    public static String hamburgerMenuTestCaseName;

    private static Properties locatorProps=null;
    private static Properties testDataProps=null;

    public void preStepHomePage() throws IOException {
        readConfig();

        locatorProps = readLocators("hamburgerMenuPage.locators");
        testDataProps = readTestData("hamburgerMenuPageTestdata.properties");

        setupTest();
    }

    public void launchHomePage(){
        launchHomePage(configProps.getProperty("URL"));
    }


    public void validateHomePageTitle() throws InterruptedException {
        Reporting.failMessage = hamburgerMenuTestCaseName+"_ValidateHomePageTitle";
        Reporting.test = Reporting.extent.createTest(hamburgerMenuTestCaseName);
        validatePageTitle(configProps.getProperty("PageTitle"));
        Reporting.logPass("HomePage Tile Validated Successfully");
    }

    //navigate to hamburger menu
    public void navigateToHamburgerMenu() {
        Reporting.failMessage = hamburgerMenuTestCaseName+"_user failed to open hamburger menu";
        clickOnElement(locatorProps.getProperty("HamburgerMenu"));
        waitForElement(locatorProps.getProperty("HMItems"));
        Reporting.logPass("User clicked on Hamburger Menu");
    }

    //select tredning item
    public void selectTrendingItem() throws InterruptedException {
        Reporting.failMessage = hamburgerMenuTestCaseName+"_user failed to navigate to Trending items page";
        clickOnElement(locatorProps.getProperty("HMTrendingItem"));
        waitForElement(locatorProps.getProperty("SearchBox"));
        validatePageTitle(testDataProps.getProperty("HMPageTitle_2"));
        Reporting.logPass("User clicked to Trending items page");
    }


    public void exitStepHomePage(){
        closeBrowser();
    }

}
