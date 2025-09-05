package com.juaracoding.healthcare.definitions.history;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.helper.ScreenshotHelper;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationLabelsValueSteps extends AuthProviders {

    @Given("pengguna ada di halaman dashboard.")
    public void step01() throws InterruptedException {
        Hook.driver = this;
        preConditionLogin();
    }

    @When("pengguna mengisi form data, facility {string}, tgl {string}, keterangan {string}.")
    public void step02(String facility, String date, String comment) throws InterruptedException {
        dashboardPage().pilihFasilitas(facility);
        Thread.sleep(1000);
        dashboardPage().ceklisReadmisson();
        Thread.sleep(1000);
        dashboardPage().pilihTanggal(date);
        dashboardPage().inputKeterangan(comment);
    }

    @And("pengguna menekan tombol booking Appoinment")
    public void step03() throws InterruptedException {
        dashboardPage().bookAppointment();
        Thread.sleep(1000);
        loginPage().clickMenuToggle();
        ScreenshotHelper.captureInputScreenshot("FormData");
    }

    @And("pengguna menekan menu History di side bar")
    public void step04() {
        historyPage().buttonHistory();
    }

    @Then("pengguna berada di halaman History dan melihat data {string} dengan nilai {string} tersedia.")
    public void step05(String labels, String value) {
        Assert.assertTrue(historyPage().isHistoryFieldUniversal(labels, value), "labels: " + labels + " value: " + value);
    }
    
}
