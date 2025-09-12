package com.belajar.cucumber.definitions.sakit;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationToSakitSteps extends AuthProviders{

    @Given("user berada di halaman sakit")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickSakitIcon();
    }

    @When("user klik tombol Ajukan Sakit")
    public void step02(){
        sakitPage().buttonAjukanSakit();
    }

    @When("user klik icon calender sakit")
    public void step03(){
        sakitPage().buttonIconCalender();
    }

    @When("user memilih tanggal mulai sakit {string}")
    public void step04(String tanggal) throws InterruptedException{
       sakitPage().pilihTanggal(tanggal);
       Thread.sleep(500);
    }

    @And("user memilih tanggal selesai sakit {string}")
    public void step05(String tanggal) throws InterruptedException{
        sakitPage().pilihTanggal(tanggal);
        sakitPage().buttonSimpanTanggal();
        Thread.sleep(500);
    }

    @And("user upload file bukti sakit {string}")
    public void step06(String fileName){
        String filePath = getPhotoPath(fileName);
        sakitPage().uploadBuktiSakit(filePath);

    }
    
    @And("user menekan tombol Ajukan")
    public void step07(){
        sakitPage().ajukanfinal();
    }

    @Then("user berhasil mengajukan sakit")
    public void step08(){
        Assert.assertTrue(sakitPage().messageSucces());
    }

    
}
