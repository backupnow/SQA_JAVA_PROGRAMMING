package com.juaracoding.healthcare.definitions.authentications;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.helper.ScreenshotHelper;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeAuthTest extends AuthProviders {


    @Given("user masuk ke halaman login.")
    public void step01() {
        Hook.driver = this;
        preTest();
        dashboardPage().buttonMakeAppointment();
    }

    @When("pengguna memasukkan username {string}.")
    public void step02(String username) {
        loginPage().setUsername(username);
        ScreenshotHelper.captureInputScreenshot("Input Username : " + username);
    }

    @And("pengguna memasukkan password {string}.")
    public void step03(String password) {
        loginPage().setPassword(password);
        ScreenshotHelper.captureInputScreenshot("Input Password : " + password);
    }

    @And("pengguna menekan tombol masuk.")
    public void step04() {
        loginPage().buttonLogin();
    }

    @Then("pengguna akan melihat pesan kesalahan {string}.")
    public void step05(String errorMessage) {
        String actualMessage = loginPage().messageError();
        Assert.assertEquals(actualMessage, errorMessage);
        ScreenshotHelper.captureInputScreenshot("Pesan Error : " + actualMessage);
    }

   

    
}
