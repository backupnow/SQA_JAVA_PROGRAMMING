package com.android.swagtest;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.swagapp.screens.InventoryScreen;
import com.android.swagapp.screens.LoginScreen;
import com.android.swagapp.utils.DriverUtil;

public class LoginTest {

    @Test()
    public void TC0001() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login("standard_user", "secret_sauce");

        String actual = inventoryScreen.getTitle();
        String expected = "PRODUCTS";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }
    
}
