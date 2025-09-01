package com.juaracoding.healthcare.definitions.orders;

import org.testng.Assert;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrdersJanjiTemuTest extends AuthProviders{

    @Given("pengguna berada di halaman dashboard")
    public void step01(){
        Hook.driver = this;
        preConditionLogin();
    }

   @When("user memilih lokasi fasilitas kesehatan {string}")
    public void step02(String nameFacility) throws InterruptedException {
        dashboardPage().pilihFasilitas(nameFacility);
    }
    
    @And("user ceklis apply for hospital readmission dan ceklis Healthcare program Medicaid")
    public void step03() throws InterruptedException{
        preConCekBox();
    }

    @And("user klik icon calender dan memilih tanggal {string}")
    public void step04(String tanggal){
        dashboardPage().pilihTanggal(tanggal);
    }

    @And("user mengisi keterangan {string}")
    public void step05(String keterangan){
        dashboardPage().inputKeterangan(keterangan);
    }

    @Then("user klik tombol booking dan Appointment berhasil di lakukan {string}")
    public void step06(String message){
        dashboardPage().bookAppointment();
        Assert.assertEquals(message, dashboardPage().messageConfirmation());
        
    }






    
}
