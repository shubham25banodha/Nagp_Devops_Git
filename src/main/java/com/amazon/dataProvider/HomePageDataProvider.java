package com.amazon.dataProvider;

import org.testng.annotations.DataProvider;

public class HomePageDataProvider {

    @DataProvider (name = "getTestCase")
    public Object[][] uIDataProviderMethod(){
        return new Object[][] {
                {"Search"},
                {"About_Us"},
                {"Tab_Navigation"}
        };
    }
}
