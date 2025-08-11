package com.android.swagtest;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.swagapp.components.HeaderComponent;
import com.android.swagapp.screens.InventoryScreen;
import com.android.swagapp.screens.LoginScreen;
import com.android.swagapp.utils.DragPositionUtil;
import com.android.swagapp.utils.DriverUtil;

public class InventoryTest {

    @Test(enabled = false)
    public void TC0007() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login();

        int actual = inventoryScreen.getTotalProduct();
        inventoryScreen.scrollDown(3);
        actual += inventoryScreen.getTotalProduct();

        int expected = 6;

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test(enabled = false)
    public void TC0008() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        HeaderComponent headerComponent = new HeaderComponent(driverUtil.getDriver());
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver(), headerComponent);

        loginScreen.login();

        inventoryScreen.drag(new DragPositionUtil(200, 100));

        String expected = "1";
        String actual = inventoryScreen.getTotalCart();
        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test(enabled = false)
    public void TC0009() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        HeaderComponent headerComponent = new HeaderComponent(driverUtil.getDriver());
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver(), headerComponent);

        
        loginScreen.login();

        inventoryScreen.drag(new DragPositionUtil(200, 100));
        
        String cartCountAfterAdd = inventoryScreen.getTotalCart();
        Assert.assertNotEquals(cartCountAfterAdd, "0", "Item should be added to cart before removal");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        inventoryScreen.removeFromCart();

        String expected = "0";
        String actual = inventoryScreen.getTotalCart();
        Assert.assertEquals(actual, expected, "Cart should be empty after removal");

        driverUtil.quitApp();
    }

    @Test()
    public void TC0010() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login();

        inventoryScreen.clickProduct(3);

        inventoryScreen.ZoomGesture();

        boolean Zoomed = inventoryScreen.zoom();
        Assert.assertTrue(Zoomed, "Gesture zoom berhasil dilakukan pada gambar produk");

        driverUtil.quitApp();
    }
}
