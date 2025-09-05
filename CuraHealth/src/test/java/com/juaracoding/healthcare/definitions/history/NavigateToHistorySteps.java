package com.juaracoding.healthcare.definitions.history;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NavigateToHistorySteps extends AuthProviders {

    @Given("user dibawa ke halaman history")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preMenuToggle();
        historyPage().buttonHistory();
    }

    @Then("user melihat halaman history {string}.")
    public void step02(String history) {
        Assert.assertEquals(history, historyPage().messageHistory());
    }
    
}
