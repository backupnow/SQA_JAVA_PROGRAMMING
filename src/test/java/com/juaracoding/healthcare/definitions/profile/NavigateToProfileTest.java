package com.juaracoding.healthcare.definitions.profile;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToProfileTest extends AuthProviders {
    

    @Given("saya dibawa ke halaman dashboard")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("saya menekan tombol menu di side bar")
    public void step02() throws InterruptedException{
        Thread.sleep(1000);
        loginPage().clickMenuToggle();
    }

    @And("saya menekan tombol menu profile")
    public void step03() throws InterruptedException {
        profilePage().btnMenuProfile();
        Thread.sleep(1000);
        dashboardPage().clickScrollUp();
    }

    @Then("saya sudah berada di halaman profile")
    public void step04() {
        Assert.assertEquals(profilePage().messageConfirProfile(), "Under construction.");
    }






}
