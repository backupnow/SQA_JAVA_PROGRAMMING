package com.juaracoding.healthcare.definitions.scroll;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.helper.ScreenshotHelper;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToScroll extends AuthProviders {

    @Given("user di bawa kehalaman dashboard")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }
    
    @When("user melakukan Scroll kebawah dan keatas")
    public void step02() throws InterruptedException{
        scrollDown().NavigateToTwittScroll();
        Thread.sleep(2000);
         ScreenshotHelper.captureInputScreenshot("logo twitter");
        dashboardPage().clickScrollUp();
    }

    @Then("user berhasil melakukan Scroll")
    public void step03() {
        Assert.assertEquals(loginPage().waitMessageHealth(), "We Care About Your Health");
    }
}
