package com.belajar.cucumber.definitions.izin;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;
import com.belajar.cucumber.pages.DashboardPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationToIzinSteps extends AuthProviders {

    @Given("user berada pada halaman dashboard sebelum ke halaman izin.")
    public void step01(){
        preConditionLogin();
        Hook.driver = this;
    }

    @When("user menekan icon izin.")
    public void step02(){
        dashboardPage().clickIzinIcon();
    }

    @Then("user dibawa ke halaman izin dengan url {string}.")
    public void step03(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);

    }

    
}
