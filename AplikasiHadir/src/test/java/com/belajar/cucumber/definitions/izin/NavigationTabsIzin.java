package com.belajar.cucumber.definitions.izin;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationTabsIzin extends AuthProviders {

    @Given("user masuk kehalaman izin")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConAjukanIzin();
    }

    @When("user menekan tombol tab terlambat dan tab pulang cepat")
    public void step02() {
        izinpage().btnTabPulangCepat();
        izinpage().btnTabTerlambat();
    }

    @And("user menekan tombol kembali")
    public void step03() {
        izinpage().buttonBack();
    }

    @Then("user kembali kehalaman dashboard dengan url {string}")
    public void step04(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(dashboardPage().getCurrentURL(), url);

    }
    
}
