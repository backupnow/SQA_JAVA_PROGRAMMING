package com.belajar.cucumber.definitions.authentications;

import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;
import com.belajar.cucumber.pages.DashboardPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveSignInSteps extends AuthProviders {

  @Given("saat menguji test positive, pengguna masuk ke halaman login.")
  public void step01() {
    preTest();
    Hook.driver = this;
  }

  @When("pengguna melakukan login dengan username {string} dan password {string} yang valid.")
  public void step02(String username, String password) {
    loginPage().performLogin(username, password);
  }

  @Then("pengguna akan di bawa ke halaman dashboard dengan url {string} untuk memeriksa hasil test.")
  public void step03(String url) {
    DashboardPage dashboardPage = new DashboardPage(getDriver());
    Assert.assertEquals(dashboardPage.getCurrentURL(), url);
  }

}