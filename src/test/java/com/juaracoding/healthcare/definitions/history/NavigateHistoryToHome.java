package com.juaracoding.healthcare.definitions.history;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateHistoryToHome extends AuthProviders {

    @Given("user berada di halaman History")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preMenuToggle();
        historyPage().buttonHistory();
    }

    @When("user menekan tombol Go To Homepage")
    public void step02() {
        historyPage().buttonGoHome();
    }

    @Then("user sudah berada di halaman Home")
    public void step03() {
        Assert.assertTrue(historyPage().isAtHistoryHero(), "user berada di halaman home");
    }
    
}
