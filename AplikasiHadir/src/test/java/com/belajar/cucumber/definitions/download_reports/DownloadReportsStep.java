package com.belajar.cucumber.definitions.download_reports;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownloadReportsStep extends AuthProviders {

    @Given("user dibawa ke halaman download reports")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickDownloadReportsIcon();
    }

    @When("user memilih tipe Reports {string}")
    public void step02(String tipeReports) {
        downloadReportsPage().pilihTipeReport(tipeReports);
    }

    @And("user menekan tombol Download Reports")
    public void step03() {
        downloadReportsPage().klikDownloadReport();
    }

    @Then("user berhasil melakukan Donwload Reports {string}")
    public void step04(String message) {
        String actual = downloadReportsPage().getMessageDownload();
        System.out.println("Pesan : " + actual);
        Assert.assertEquals(actual, message, "Download succes");

    }


    
    
}
