package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeNoInputPulangCepat extends AuthProviders {

    @Given("pengguna di bawa kehalaman izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
    }

    @When("pengguna klik tombol Tab Pulang Cepat")
    public void step02() {
        izinpage().btnTabPulangCepat();
    }

    @And("pengguna klik tombol Ajukan Pulang Cepat")
    public void step03() {
        izinpage().buttonAjukanCepat();
    }

    @And("pengguna memilih jam {int} menit {int}, lalu klik tombol Ajukan")
    public void step04(int jam, int menit) {
        izinpage().clickIconJam();
        dragnDrop().pilihJam(jam, menit);
        izinpage().buttonAjukanFinish();
    }

    @Then("Muncul pesan error peringatan {string} dan {string}")
    public void step05(String note, String date) {
        String actualNote = izinpage().pesanNote();
        String actualDate = izinpage().pesanTanggal();
        Assert.assertEquals(note.equals(actualNote), date.equals(actualDate));
    }
    
}
