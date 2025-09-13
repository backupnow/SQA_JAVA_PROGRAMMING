package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeResetTerlambat extends AuthProviders {

    @Given("Pengguna berada di halaman Izin.")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabTerlambat();
    }

    @When("Pengguna klik tombol pengajuan.")
    public void step02() {
        izinpage().buttonAjukanTerlambat();
    }

    @And("Pengguna mengisi data berupa : tgl {string}, jam {int} menit {int}, keterangan {string}.")
    public void step03(String inputTanggal, int jam, int menit, String inputText) throws InterruptedException {
        preCondInputDataIzin(inputTanggal, jam, menit, inputText);
    }

    @Then("Pengguna klik tombol reset, dan tanggal tidak kosong.")
    public void step04() {
        izinpage().buttonReset();
        String actual = izinpage().dateNotReset();
        String expected = "09/13/2025";
        Assert.assertEquals(actual, expected);
    }
    
}
