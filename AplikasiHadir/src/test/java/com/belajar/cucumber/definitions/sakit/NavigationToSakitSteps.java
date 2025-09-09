package com.belajar.cucumber.definitions.sakit;

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

public class NavigationToSakitSteps extends AuthProviders {

     @Given("user berada pada halaman dashboard sebelum ke halaman sakit.")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
    }
    
    @When("user menekan icon sakit.")
    public void step02(){
        dashboardPage().clickSakitIcon();
    }

    @Then("user dibawa ke halaman sakit dengan url {string}.")
    public void step03(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);

    }
    
}
