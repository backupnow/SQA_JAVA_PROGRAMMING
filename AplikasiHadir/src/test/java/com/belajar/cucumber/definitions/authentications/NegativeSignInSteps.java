package com.belajar.cucumber.definitions.authentications;
import org.testng.Assert;

import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeSignInSteps extends AuthProviders{

  @Given("pengguna masuk ke halaman login.")
  public void step01() {
    preTest();
    Hook.driver = this;
  }

  @When("pengguna memasukkan username {string}.")
  public void step02(String email) {
    loginPage().setEmailLogin(email);
  }

  @And("pengguna memasukkan password {string}.")
  public void step03(String password) {
    loginPage().setPasswordLogin(password);
  }

  @And("pengguna menekan tombol masuk.")
  public void step04() throws InterruptedException {
    loginPage().clickMasukButtonError();
    Thread.sleep(1000);
  }

  @Then("pengguna akan melihat pesan kesalahan {string}.")
  public void step05(String message) {
    Assert.assertEquals(loginPage().getErrorMessage(), message);
  }
}
