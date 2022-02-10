package com.amazon.tests;

import com.amazon.dataProvider.AddressPageDataProvider;
import com.amazon.dataProvider.HomePageDataProvider;
import com.amazon.listener.AmazonListener;
import com.amazon.ui.AddressPage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Locale;

public class Address extends AddressPage {
    @BeforeClass
    public void preStep() throws IOException {
        preStepAddressPage();
    }

    @BeforeMethod
    public void initTestCase(){
        launchHomePage();
    }

    //Execute Address test cases
    @Test(dataProvider = "getTestCase", dataProviderClass = AddressPageDataProvider.class)
    public void testAddress(String addressTestCases) throws Exception {
        System.out.println("*************************************************************************");
        System.out.println("TestcaseName is  : "+addressTestCases);
        System.out.println("*************************************************************************");

        addressTestCaseName = addressTestCases.toLowerCase();
        switch (addressTestCases.toLowerCase()){
            case "enter_wrong_pincode":
                validateHomePageTitle();
                navigateToSelectAddress();
                enterPicode();
                break;
            case "enter_correct_pincode":
                validateHomePageTitle();
                navigateToSelectAddress();
                enterPicode();
                break;
        }
    }

    @AfterMethod
    public void finishTestCase(){
        launchHomePage();
    }

    @AfterClass
    public void exitStep(){
        exitStepHomePage();
    }

}
