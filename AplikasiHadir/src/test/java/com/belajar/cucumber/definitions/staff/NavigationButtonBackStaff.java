package com.belajar.cucumber.definitions.staff;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationButtonBackStaff extends AuthProviders {

    @Given("user berada di halaman staff Page")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickStaffIcon();
    }

    @When("user klik tombol kembali")
    public void step02() throws InterruptedException {
        staffPage().buttonBack();
        Thread.sleep(500);
    }

    @Then("user berada di halaman utama, {string}")
    public void step03(String url) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(dashboardPage().getCurrentURL(), url);
    }
    
}
