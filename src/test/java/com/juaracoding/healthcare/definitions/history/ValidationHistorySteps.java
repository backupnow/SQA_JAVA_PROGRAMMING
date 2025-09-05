package com.juaracoding.healthcare.definitions.history;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.helper.ScreenshotHelper;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationHistorySteps extends AuthProviders {

    @Given("pengguna berada di halaman dashboard")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("pengguna melakukan submit data {string} dan {string} serta {string}")
    public void step02(String facility, String text, String date) {
        dashboardPage().pilihFasilitas(facility);
        dashboardPage().inputKeterangan(text);
        dashboardPage().pilihTanggal(date);
    }

    @And("user klik tombol booking Appoinment")
    public void step03() throws InterruptedException {
        dashboardPage().bookAppointment();
        Thread.sleep(1000);
        loginPage().clickMenuToggle();
        ScreenshotHelper.captureInputScreenshot("dataAppoinment");
    }

    @And("user klik menu History di side bar")
    public void step04() {
        historyPage().buttonHistory();
    }

    @Then("user berada di halaman History dan data history tersedia {string}")
    public void step05(String expected) {
        Assert.assertTrue(historyPage().isDateVisible(expected), "date" + expected + "sesuai");
    }

    
}
