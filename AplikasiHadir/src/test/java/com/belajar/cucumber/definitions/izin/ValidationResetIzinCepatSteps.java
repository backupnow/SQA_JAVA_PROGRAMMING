package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationResetIzinCepatSteps extends AuthProviders {

    @Given("user di bawa kehalaman menu izin")
    public void step01() throws InterruptedException  {
        Hook.driver = this;
        preConAjukanIzin();
        izinpage().btnTabPulangCepat();
    }

    @When("user menekan tombol Pengajuan")
    public void step02() {
        izinpage().buttonAjukanCepat();
    }

    @And("user klik icon calender, input tanggal {string}")
    public void step03(String date) throws InterruptedException {
        izinpage().clickIconCalender();
        Thread.sleep(1000);
        izinpage().pilihTanggal(date);
    }

    @And("user klik icon jam input jam {int} menit {int}, dan input keterangan {string}.")
    public void step04(int jam, int menit, String comment) {
        izinpage().clickIconJam();
        dragnDrop().pilihJam(jam, menit);
        izinpage().inputKeterangan(comment);
    }

    @Then("lalu user menekan tombol Reset")
    public void step05() {
        izinpage().buttonReset();
        Assert.assertEquals(izinpage().getInputKeterangan(), "", "input telah kosong");
    }
    
}
