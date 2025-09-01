package com.juaracoding.healthcare.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    private WebDriver driver;

    @FindBy(id = "btn-make-appointment")
    private WebElement btnMakeAppointment;

    @FindBy(xpath = "//label[@for='combo_facility']")
    private WebElement facility;

    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
    private WebElement textConfirmation;

    @FindBy(id = "combo_facility")
    private WebElement selectFacility;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement applyReadmission;

    @FindBy(id = "radio_program_medicaid")
    private WebElement btnHealthProgram;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar']")
    private WebElement iconCalender;

    @FindBy(id = "txt_visit_date")
    private WebElement datePicker;

    @FindBy(id = "txt_comment")
    private WebElement comment;

    @FindBy(id = "btn-book-appointment")
    private WebElement booking;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void btnMakeAppointment(){
        btnMakeAppointment.click();
    }

    public void buttonMakeAppointment(){
        btnMakeAppointment.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("profile.php#login"));
    }

    public void uiLabel(){
        facility.getText();
    }

    public String messageConfirmation(){
        return textConfirmation.getText();
    }

    public void pilihFasilitas(String namaFasilitas) {
        selectFacility.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Select select = new Select(selectFacility);
        select.selectByVisibleText(namaFasilitas);
    }

    public void ceklisReadmisson(){
        applyReadmission.click();
       new WebDriverWait(driver, Duration.ofSeconds(4))
        .until(d -> applyReadmission.isSelected());

    }

    public void ceklisButtonHealthProgram(){
        btnHealthProgram.click();
        new WebDriverWait(driver, Duration.ofSeconds(4))
        .until(d -> btnHealthProgram.isSelected());

    }

    public void clicIconCalender(){
        iconCalender.click();
    }

    public void pilihTanggal(String tanggal){
        iconCalender.click();
        datePicker.clear();
        datePicker.sendKeys(tanggal);
        datePicker.sendKeys(Keys.ENTER); 
    }

    public void inputKeterangan(String keterangan) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.elementToBeClickable(comment));
        comment.clear();
        comment.sendKeys(keterangan);
    }

    public void bookAppointment(){
        booking.click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

}
