package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeNoInputTerlambat extends AuthProviders {

    @Given("pengguna berada di halaman izin")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
    }
    
    @When("user klik menu izin")
    public void step02(){
        dashboardPage().clickIzinIcon();
        driver.navigate().refresh();
    } 

    @And("user klik tombol ajukan izin terlambat")
    public void step03(){
        izinpage().buttonAjukanTerlambat();
    }
    
    @And("user memilih jam {int} menit {int}.")
    public void step04(Integer jam, Integer menit){
        izinpage().iconJam();
        dragnDrop().pilihJam(jam, menit);
        
    }
    @And("user klik tombol ajukan")
    public void step05(){
        izinpage().buttonAjukanFinish();
    }

    @Then("Muncul pesan error {string} dan {string}")
    public void step06(String pesanNote, String pesanTanggal){
        Assert.assertEquals(pesanNote, izinpage().pesanNote());
        Assert.assertEquals(pesanTanggal, izinpage().pesanTanggal());
    }


}
