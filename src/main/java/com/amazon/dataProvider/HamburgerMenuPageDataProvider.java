package com.amazon.dataProvider;

import org.testng.annotations.DataProvider;

public class HamburgerMenuPageDataProvider {

    @DataProvider (name = "getTestCase")
    public Object[][] uIDataProviderMethod(){
        return new Object[][] {
                {"Trending_Menu"}
        };
    }
}
