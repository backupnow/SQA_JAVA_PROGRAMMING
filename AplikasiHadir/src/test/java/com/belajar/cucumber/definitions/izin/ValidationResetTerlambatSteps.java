package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationResetTerlambatSteps extends AuthProviders {

    @Given("user di bawa kehalaman izin page")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabTerlambat();
    }

    @When("user menekan tombol pengajuan di form")
    public void step02() {
        izinpage().buttonAjukanTerlambat();
    }

    @And("user mengisi data : tanggal {string}, jam {int} menit {int}, keterangan {string}")
    public void step03(String date, int jam, int menit, String note) throws InterruptedException {
        preConInputFormIzin(date, jam, menit, note);
    }

    @Then("user klik tombol reset dan form izin kosong")
    public void step04() {
        izinpage().buttonReset();
        Assert.assertEquals(izinpage().getInputKeterangan(), "", "form is empty");
    }
    
}
