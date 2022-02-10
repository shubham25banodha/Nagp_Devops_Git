package com.amazon.tests;

import com.amazon.dataProvider.*;
import com.amazon.ui.HamburgerMenuPage;
import com.amazon.ui.HomePage;
import org.testng.annotations.*;

import java.io.IOException;

public class HamburgerMenu extends HamburgerMenuPage {

//    public static Properties locators = getLocators("Locators/homePage");

    @BeforeClass
    public void preStep() throws IOException {
        preStepHomePage();
    }

    @BeforeMethod
    public void initTestCase(){
        launchHomePage();
    }

    //Execute Hamburger testcases
    @Test(dataProvider = "getTestCase", dataProviderClass = HamburgerMenuPageDataProvider.class)
    public void testHamburgerMenu(String hamburgerMenuTestCases) throws Exception {
        System.out.println("*************************************************************************");
        System.out.println("TestcaseName is  : "+hamburgerMenuTestCases);
        System.out.println("*************************************************************************");

        hamburgerMenuTestCaseName = hamburgerMenuTestCases;
        switch (hamburgerMenuTestCases.toLowerCase()){
            case "trending_menu":
                validateHomePageTitle();
                navigateToHamburgerMenu();
                selectTrendingItem();
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
