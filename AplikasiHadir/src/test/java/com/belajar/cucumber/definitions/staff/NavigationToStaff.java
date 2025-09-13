package com.belajar.cucumber.definitions.staff;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NavigationToStaff extends AuthProviders {

    @Given("user di bawa kehalaman utama")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @And("user klik menu Staff")
    public void step02() {
        dashboardPage().clickStaffIcon();
    }

    @Then("user berada di halaman Staff")
    public void step03() {
        Assert.assertEquals(staffPage().messagePage(), "Tidak ada lagi data");
    }
    
}
