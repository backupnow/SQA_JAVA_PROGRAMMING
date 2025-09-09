package com.belajar.cucumber.definitions.izin;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationTotalListTerlambat extends AuthProviders {

    
    @Given("pengguna masuk kehalaman menu izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
    }

    @When("pengguna mengklik tombol tab terlambat")
    public void step02() {
        izinpage().btnTabTerlambat();
    }

    @And("pengguna melihat List terlambat")
    public void step03() {
        int total = izinpage().getTotalListIzin();
        System.out.println("Total Data : " + total);
    }

    @Then("pengguna telah melihat total list terlambat")
    public void step04() {
        int expected = 13;
        int actual = izinpage().getTotalListIzin();
        System.out.println("expected: " + expected + ", actual : " + actual);
        Assert.assertEquals(expected, actual);
        izinpage().buttonBack();
    }
}
