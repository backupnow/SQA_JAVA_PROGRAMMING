package com.belajar.cucumber.definitions.sakit;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeNoDataAjukanSteps extends AuthProviders {

    @Given("pengguna berada di halaman sakit")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickSakitIcon();
    }

    @When("pengguna klik tombol Ajukan Sakit")
    public void step02(){
        sakitPage().buttonAjukanSakit();
    }

    @And("pengguna klik tombol konfirmasi pengajuan")
    public void step03() throws InterruptedException{
        Thread.sleep(1000);
        sakitPage().ajukanfinal();
    }

    @Then("pengguna mendapat pesan {string}")
    public void step04(String message){
        Assert.assertEquals(message, sakitPage().getMessageError2Text());
        
    }
    
}
