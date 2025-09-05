package com.juaracoding.healthcare.definitions.orders;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.helper.ScreenshotHelper;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeOrdersSteps extends AuthProviders {

    @Given("pengguna ada di halaman dashboard")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("pengguna melakukan Scroll pada halaman dashboard")
    public void step02() {
        scrollDown().navigateToAppointment();
    }

    @And("user klik tombol booking tanpa mengisi data")
    public void step03() {
        dashboardPage().bookAppointment();
    }

    @Then("user melihat pesan error {string}")
    public void step04(String expected) {
        String actualMessage = dashboardPage().validationUiError();
        Assert.assertTrue(actualMessage.contains(expected));
         ScreenshotHelper.captureInputScreenshot("message UI : " + expected);
    }
    
}
