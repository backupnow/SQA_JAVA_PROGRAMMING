package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositivePengajuanIzinPulangCepat extends AuthProviders {

    @Given("Pengguna di bawa kehalaman izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabPulangCepat();
    }

    @When("pengguna menekan tombol pengajuan di form")
    public void step02() {
        izinpage().buttonAjukanCepat();
    }

    @And("pengguna memasukkan data : tanggal {string}, jam {int} menit {int}, keterangan {string}")
    public void step03(String date, int jam, int menit, String text) throws InterruptedException {
        preCondInputDataIzin(date, jam, menit, text);
    }

    @Then("pengguna menekan tombol Ajukan, dan melihat isi catatan {string}")
    public void step04(String expected) {
        izinpage().buttonAjukanFinish();
        String actual = izinpage().getValueByLabel("Catatan");
        Assert.assertEquals(actual, expected);
    }
    
}
