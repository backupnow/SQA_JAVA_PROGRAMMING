package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationTotalListIzinCepat extends AuthProviders {

    @Given("user masuk kehalaman menu izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
    }

    @When("user mengklik tombol tab pulang cepat")
    public void step02() {
        izinpage().btnTabPulangCepat();
    }

    @And("user melihat List Pulang Cepat")
    public void step03() {
        int total = izinpage().getTotalListIzin();
        System.out.println("Total Data : " + total);
    }

    @Then("user telah melihat total list cepat")
    public void step04() throws InterruptedException {
        int Expected = 52;
        int actualTotal = izinpage().getTotalListIzin();
        System.out.println("Expected : " + Expected + ", actualTotal : " + actualTotal);
        Assert.assertEquals(actualTotal, Expected);
        Thread.sleep(1000);
        izinpage().buttonBack();
    }
    
}
