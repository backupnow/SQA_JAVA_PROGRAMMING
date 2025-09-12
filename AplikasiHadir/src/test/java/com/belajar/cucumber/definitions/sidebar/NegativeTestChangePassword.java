package com.belajar.cucumber.definitions.sidebar;

import org.testng.Assert;

import com.belajar.cucumber.definitions.authentications.Hook;
import com.belajar.cucumber.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeTestChangePassword extends AuthProviders {

    @Given("pengguna di bawa kehalaman Change Password")
    public void step01() {
        Hook.driver = this;
        preConditionLogin();
        dashboardPage().clickBurgerButton();
    }

    @When("pengguna input password baru {string} dan input konfirmasi {string}")
    public void step02(String pass, String confirm) throws InterruptedException {
        changePass().changePassword();
        changePass().inputPass(pass);
        Thread.sleep(500);
        changePass().inputConfirm(confirm);
    }

    @And("pengguna menekan tombol Konfirmasi New Password")
    public void step03() {
        changePass().buttonConfirm();
    }

    @Then("pengguna gagal mengubah password dan melihat pesan {string}, {string}")
    public void step04(String expectedPass, String expectedConfirm) {
        String actualPass = changePass().getPasswordErrorMessage();
        String actualConfirm = changePass().getConfirmPasswordErrorMessage();
        String actualCombined = actualPass + "||" + actualConfirm;
        String expectedCombined = expectedPass + "||" + expectedConfirm;
        Assert.assertEquals(actualCombined, expectedCombined);
        System.out.println("Message : " + actualPass);
        System.out.println("Message : " + actualConfirm);

    }
    
}
