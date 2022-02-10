package com.amazon.tests;

import com.amazon.dataProvider.HomePageDataProvider;
import com.amazon.dataProvider.SignInPageDataProvider;
import com.amazon.ui.HomePage;
import com.amazon.ui.SignInPage;
import org.testng.annotations.*;

import java.io.IOException;

public class SignIn extends SignInPage {

//    public static Properties locators = getLocators("Locators/homePage");

    @BeforeClass
    public void preStep() throws IOException {
        preStepHomePage();
    }

    @BeforeMethod
    public void initTestCase(){
        launchHomePage();
    }

    //Execute sign in test cases
    @Test(dataProvider = "getTestCase", dataProviderClass = SignInPageDataProvider.class)
    public void testSignIn(String signInTestCases) throws Exception {
        System.out.println("*************************************************************************");
        System.out.println("TestcaseName is  : "+signInTestCases);
        System.out.println("*************************************************************************");

        signInTestCaseName = signInTestCases;
        switch (signInTestCases.toLowerCase()){
            case "negative_signin_byinvalidnumber":
                validateHomePageTitle();
                navigateToSignInPage();
                signInWithInvalidNumber();
                break;
            case "negative_signin_byunregisternumber":
                validateHomePageTitle();
                navigateToSignInPage();
                signInWithUnRegisteredEmail();
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
