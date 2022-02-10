package com.amazon.dataProvider;

import org.testng.annotations.DataProvider;

public class SignInPageDataProvider {

    @DataProvider (name = "getTestCase")
    public Object[][] uIDataProviderMethod(){
        return new Object[][] {
                {"Negative_SignIn_ByInvalidNumber"},
                {"Negative_SignIn_ByUnRegisterNumber"},
        };
    }
}
