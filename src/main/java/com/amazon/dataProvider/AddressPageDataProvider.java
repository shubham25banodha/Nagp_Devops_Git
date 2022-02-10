package com.amazon.dataProvider;

import org.testng.annotations.DataProvider;

public class AddressPageDataProvider {

    @DataProvider (name = "getTestCase")
    public Object[][] uIDataProviderMethod(){
        return new Object[][] {
                {"Enter_Wrong_Pincode"},
                {"Enter_Correct_Pincode"}
        };
    }
}
