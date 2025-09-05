package com.juaracoding.healthcare.definitions.authentications;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutTest extends AuthProviders {

    @Given("user berada di halaman dashboard")
    public void step01() throws InterruptedException{
        Hook.driver = this;
        preConditionLogin();
        Thread.sleep(2000);
    }

    @When("user menekan tombol menu samping")
    public void step02() {
        loginPage().clickMenuToggle();
    }

    @And("user menekan tombol logout")
    public void step03() throws InterruptedException{
        Thread.sleep(3000);
        loginPage().buttonLogOut();
    }

    @Then("user telah keluar dari halaman login")
    public void step04() {
        Assert.assertEquals(loginPage().waitMessageHealth(), "We Care About Your Health");
    }
    
}
