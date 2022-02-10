package com.amazon.ui;

import com.amazon.framework.Base;
import com.amazon.framework.Reporting;
import com.amazon.listener.AmazonListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class AddressPage extends Base {
    WebElement webElement;
    public static String addressTestCaseName;
    HomePage HP = new HomePage();

    private static Properties locatorProps=null;
    private static Properties testDataProps=null;

    public void preStepAddressPage() throws IOException {
        readConfig();

        locatorProps = readLocators("addressPage.locators");
        testDataProps = readTestData("addressPageTestdata.properties");

        setupTest();
    }

    public void launchHomePage(){
        launchHomePage(configProps.getProperty("URL"));
    }

    public void validateHomePageTitle() throws InterruptedException {
        Reporting.failMessage = addressTestCaseName+"_ValidatePageTitle";
        Reporting.test = Reporting.extent.createTest(addressTestCaseName);
        validatePageTitle(configProps.getProperty("PageTitle"));
        Reporting.logPass("HomePage Tile Validated Successfully");
    }

    //navigate to select address icon
    public void navigateToSelectAddress() throws InterruptedException {
        Reporting.failMessage = addressTestCaseName+"_navigateToSelectAddresse";
        clickOnElement(locatorProps.getProperty("SelectYourAddress"));
        waitForElement(locatorProps.getProperty("AddressPopoverHeading"));
        bAssertion(testDataProps.getProperty("AddressPopoverHeadingText"),bGetText(locatorProps.getProperty("AddressPopoverHeading")));
        Reporting.logPass("Successfully navigated to add address popup");
    }

    //enter pincode
    public void enterPicode() throws InterruptedException {
        Reporting.failMessage = addressTestCaseName+"_Fail";
        switch(addressTestCaseName){
            case "enter_wrong_pincode":
                enterTextField(locatorProps.getProperty("PinCodeTextField"),testDataProps.getProperty("WrongPinCode"));
                clickOnElement(locatorProps.getProperty("SubmitPincode"));
                waitForElement(locatorProps.getProperty("WrongPincodeAllert"));
                bAssertion(testDataProps.getProperty("WrongPincodeAllertMessage"),bGetText(locatorProps.getProperty("WrongPincodeAllert")));
                break;
            case "enter_correct_pincode":
                enterTextField(locatorProps.getProperty("PinCodeTextField"),testDataProps.getProperty("CorrectPinCode"));
                clickOnElement(locatorProps.getProperty("SubmitPincode"));
                Thread.sleep(5000);
                System.out.println(bGetText(locatorProps.getProperty("SelectYourAddress")));
                break;
        }
        Reporting.logPass("User "+addressTestCaseName);
    }



    public void exitStepHomePage(){
        closeBrowser();
    }
}
