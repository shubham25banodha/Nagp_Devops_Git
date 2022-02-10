package com.amazon.tests;

import com.amazon.ui.HomePage;
import com.amazon.dataProvider.*;
import org.testng.annotations.*;

import java.io.IOException;

public class Home extends HomePage {

    @BeforeClass
    public void preStep() throws IOException {
        preStepHomePage();
    }

    @BeforeMethod
    public void initTestCase(){
        launchHomePage();
    }

    //Test cases
    @Test(dataProvider = "getTestCase", dataProviderClass = HomePageDataProvider.class)
    public void testHome(String homeTestCases) throws Exception {
        System.out.println("*************************************************************************");
        System.out.println("TestcaseName is  : "+homeTestCases);
        System.out.println("*************************************************************************");

        homeTestCaseName = homeTestCases;
        switch (homeTestCases.toLowerCase()){
            case "search":
                validateHomePageTitle();
                search();
                validateResultPage();
                break;
//            case "about_us":
//                validateHomePageTitle();
//                navigateAboutUs();
//                validateResultPage();
//                break;
//            case "tab_navigation":
//                validateHomePageTitle();
//                navigateTab();
//                break;
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
