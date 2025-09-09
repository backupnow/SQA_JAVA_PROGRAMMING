package com.belajar.cucumber.definitions.sakit;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationButtonReset extends AuthProviders {

    @Given("user di bawa kehalaman sakit.")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickSakitIcon();
    }

    @When("user menekan tombol pengajuan sakit")
    public void step02() {
        sakitPage().buttonAjukanSakit();
    }

    @And("user memilih tanggal mulai {string} dan tanggal akhir {string}")
    public void step03(String start, String end) throws InterruptedException {
        sakitPage().buttonIconCalender();
        sakitPage().pilihTanggal(start);
        Thread.sleep(1000);
        sakitPage().pilihTanggal(end);
        sakitPage().buttonSimpanTanggal();
    }

    @Then("lalu user menekan tombol reset, maka form kosong")
    public void step04() throws InterruptedException {
        Thread.sleep(2000);
        sakitPage().buttonResetForm();
        Assert.assertTrue(sakitPage().formEmptyVisible(), "/");
    }


    
}
