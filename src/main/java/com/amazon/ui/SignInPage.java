package com.amazon.ui;

import com.amazon.framework.Base;
import com.amazon.framework.Reporting;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;


public class SignInPage extends Base {
    WebElement webElement;
    public static String signInTestCaseName;

    private static Properties locatorProps=null;
    private static Properties testDataProps=null;

    public void preStepHomePage() throws IOException {
        readConfig();

        locatorProps = readLocators("signInPage.locators");
        testDataProps = readTestData("signInPageTestdata.properties");

        setupTest();
    }

    public void launchHomePage(){
        launchHomePage(configProps.getProperty("URL"));
    }


    public void validateHomePageTitle() throws InterruptedException {
        Reporting.failMessage = signInTestCaseName+"_ValidateHomePageTitle";
        Reporting.test = Reporting.extent.createTest(signInTestCaseName);
        validatePageTitle(configProps.getProperty("PageTitle"));
        Reporting.logPass("HomePage Tile Validated Successfully");
    }


    //navigate to signIn page
    public void navigateToSignInPage() {
        Reporting.failMessage = signInTestCaseName+"_navigateToSignInPage_Fail";
        waitForElement(locatorProps.getProperty("SignInIcon"));
        clickOnElement(locatorProps.getProperty("SignInIcon"));
        waitForElement(locatorProps.getProperty("EmailMobileNoTextField"));
        validatePageTitle(testDataProps.getProperty("SignInPageTitle"));
        Reporting.logPass("Successfully Navigated to SignIn Page");
    }

    //enter invalid number
    public void signInWithInvalidNumber() {
        Reporting.failMessage = signInTestCaseName+"_signIn with invalid number fail";
        enterTextField(locatorProps.getProperty("EmailMobileNoTextField"),testDataProps.getProperty("InvalidMobileNumber"));
        clickOnElement(locatorProps.getProperty("ContinueButton"));
        bAssertion(testDataProps.getProperty("IncorrectNumberAlertText"),bGetText(locatorProps.getProperty("IncorrectNumberAlert")));
        Reporting.logPass("SignIn with invalid mobile number step passed");
    }

    //enter unregistered email
    public void signInWithUnRegisteredEmail(){
        Reporting.failMessage = signInTestCaseName+"_SignIn with un-registered email fail";
        enterTextField(locatorProps.getProperty("EmailMobileNoTextField"),testDataProps.getProperty("UnRegisteredEmail"));
        clickOnElement(locatorProps.getProperty("ContinueButton"));
        bAssertion(testDataProps.getProperty("UnRegisteredEmailAlertText"),bGetText(locatorProps.getProperty("IncorrectNumberAlert")));
        Reporting.logPass("SignIn with un-registered email step passed");
    }

    public void exitStepHomePage(){
        closeBrowser();
    }

}
