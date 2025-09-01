package com.juaracoding.healthcare.definitions.authentications;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juaracoding.healthcare.definitions.providers.AuthProviders;
import com.juaracoding.healthcare.pages.DashboardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends AuthProviders {

    @Given("pengguna masuk ke halaman login.")
    public void step01(){
        Hook.driver = this;
        preTest();
    }

    @When("user klik button make appointment")
    public void step02(){
        dashboardPage().buttonMakeAppointment();
    }

    @And("user melakukan login dengan username dan password")
    public void step03() throws InterruptedException{
        Thread.sleep(500);
        loginPage().loginPerform();
    }

    @Then("user di bawa kehalaman dengan url {string}")
    public void step04(String url){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(url));
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals(dashboardPage.getCurrentURL(), url);
    }


    

}
