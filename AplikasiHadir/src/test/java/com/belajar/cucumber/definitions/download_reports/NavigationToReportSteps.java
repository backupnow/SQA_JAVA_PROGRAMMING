package com.belajar.cucumber.definitions.download_reports;


import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationToReportSteps extends AuthProviders {

    @Given("user di bawa kehalaman utama atau dashboard")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("user klik menu Download Reports")
    public void step02() {
        dashboardPage().clickDownloadReportsIcon();
    }

    @Then("user berada di halaman Download Reports")
    public void step03() {
        String actual = downloadReportsPage().getMessagepage();
        Assert.assertEquals(actual, downloadReportsPage().getMessagepage());
        downloadReportsPage().buttonBack();
    }
    
}
