package com.belajar.cucumber.definitions.sakit;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ValidationTotalReqSakit extends AuthProviders {

    @Given("pengguna di bawa kehalaman sakit")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickSakitIcon();
    }

    @And("user melihat total List Request sakit")
    public void step03() {
        int total = sakitPage().getTotalReqSakit();
        System.out.println("Total Data : " + total);
    }

    @Then("dan user telah mengetahui total request")
    public void step04() {
        int expectedTotal = 37;
        int actualTotal = sakitPage().getTotalReqSakit();
        System.out.println("Expected : " + expectedTotal + ", Actual : " + actualTotal);
        Assert.assertEquals(actualTotal, expectedTotal);
    }
    
}
