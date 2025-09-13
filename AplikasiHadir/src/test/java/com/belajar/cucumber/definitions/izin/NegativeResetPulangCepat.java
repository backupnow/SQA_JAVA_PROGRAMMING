package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeResetPulangCepat extends AuthProviders {

    @Given("Pengguna berada di halaman Izin Page")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabPulangCepat();
    }

    @When("Pengguna klik tombol pengajuan untuk menampilkan form")
    public void step02() {
        izinpage().buttonAjukanCepat();
    }

    @And("Pengguna menginput data berupa : tgl {string}, jam {int} menit {int}, keterangan {string}.")
    public void step03(String tanggal, int jam, int menit, String note) throws InterruptedException {
        preCondInputDataIzin(tanggal, jam, menit, note);
    }

    @Then("Pengguna menekan tombol reset, tanggal tidak kosong")
    public void step04() {
        izinpage().buttonReset();
        String actual = izinpage().dateNotReset();
        Assert.assertEquals(actual, "09/13/2025", "tgl tidak ke reset");
    }
    
}
