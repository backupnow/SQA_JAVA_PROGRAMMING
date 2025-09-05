package com.juaracoding.healthcare.definitions.history;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeHistoryNoData extends AuthProviders {

    @Given("user berada di halaman dashboard.")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("user klik tombol menu samping")
    public void step02() {
        loginPage().clickMenuToggle();
    }

    @And("user klik menu History")
    public void step03() {
        historyPage().buttonHistory();
    }

    @Then("user berada di halaman history tanpa data Appointment {string}")
    public void step04(String message) {
        String actual = historyPage().messageNoData();
        Assert.assertTrue(actual.contains(message));
    }
    
}
