package com.belajar.cucumber.definitions.download_reports;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeDonwloadReport extends AuthProviders {

    @Given("pengguna berada di halaman download Reports")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickDownloadReportsIcon();
    }

    @When("pengguna tidak memilih tipe Reports, dan klik button download")
    public void step02() throws InterruptedException {
        Thread.sleep(1000);
        downloadReportsPage().buttonDownloadReports();
    }

    @Then("pengguna mendapat pesan, {string}")
    public void step03(String message) {
        Assert.assertEquals(message, downloadReportsPage().getMessageError());
    }

    
}
