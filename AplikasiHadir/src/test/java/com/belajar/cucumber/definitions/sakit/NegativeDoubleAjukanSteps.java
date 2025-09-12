package com.belajar.cucumber.definitions.sakit;

import org.testng.Assert;
import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeDoubleAjukanSteps extends AuthProviders {

    @Given("pengguna berada di halaman pengajuan sakit")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickSakitIcon();   
    }

    @When("pengguna menekan tombol Ajukan Sakit")
    public void step02(){
        sakitPage().buttonAjukanSakit();
    }

    @When("pengguna membuka kalender untuk memilih tanggal sakit")
    public void step03(){
        sakitPage().buttonIconCalender();
    }

    @When("pengguna memilih tanggal mulai sakit {string}")
    public void step04(String tanggal) throws InterruptedException{
       sakitPage().pilihTanggal(tanggal);
       Thread.sleep(500);
    }

    @And("pengguna memilih tanggal selesai sakit {string}")
    public void step05(String tanggal) throws InterruptedException{
        sakitPage().pilihTanggal(tanggal);
        sakitPage().buttonSimpanTanggal();
        Thread.sleep(500);
    }

    @And("pengguna mengupload bukti sakit {string}")
    public void step06(String fileName) {
        String filePath = getPhotoPath(fileName);
        sakitPage().uploadBuktiSakit(filePath);
    }

    @And("pengguna menekan tombol konfirmasi pengajuan")
    public void step07() {
        sakitPage().ajukanfinal();
    }

    @Then("pengguna gagal ajukan dan muncul pesan {string}")
    public void step08(String message){
        Assert.assertEquals(message,sakitPage().getMessage());
        
    }


}
