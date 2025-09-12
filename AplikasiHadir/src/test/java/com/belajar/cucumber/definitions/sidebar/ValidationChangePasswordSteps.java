package com.belajar.cucumber.definitions.sidebar;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationChangePasswordSteps extends AuthProviders {

    @Given("pengguna berada di halaman utama atau dashboard")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("pengguna klik sidebar pada ujung kanan atas")
    public void step02() {
        dashboardPage().clickBurgerButton();
    }

    @And("pengguna klik ubah password dan masuk kehalaman ubah password")
    public void step03() throws InterruptedException {
        Thread.sleep(1000);
        changePass().changePassword();
    }

    @And("pengguna mengisi password baru {string} dan {string}, lalu submit konfirmasi password")
    public void step04(String value1, String value2) throws InterruptedException {
        changePass().inputPass(value1);
        Thread.sleep(1000);
        changePass().inputConfirm(value2);
        changePass().buttonConfirm();
    }

    @Then("pengguna berhasil melakukan ChangePassword, {string}")
    public void step05(String expected) throws InterruptedException {
        String actual = changePass().messageSuccess();
        Assert.assertEquals(actual, expected);
        Thread.sleep(1000);
        changePass().okMessage();
    }
    
}
