package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositivePengajuanIzinTerlambat extends AuthProviders {

    @Given("pengguna menuju kehalaman izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabTerlambat();
    }

    @When("pengguna klik tombol pengajuan terlambat di form")
    public void step02() {
        izinpage().buttonAjukanTerlambat();
    }

    @And("pengguna input data : Tanggal {string}, jam {int} menit {int}, keterangan {string}")
    public void step03(String tanggal, int jam, int menit, String keterangan) throws InterruptedException {
        preCondInputDataIzin(tanggal, jam, menit, keterangan);
    }

    @Then("pengguna melihat nilai dari label {string} adalah {string}")
    public void step04(String actualLabel, String expectedValue) {
        izinpage().buttonAjukanFinish();
        String labelText = izinpage().getValueByLabel(actualLabel);
        Assert.assertEquals(labelText, expectedValue);
    }
    
}
