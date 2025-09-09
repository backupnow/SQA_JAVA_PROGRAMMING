package com.belajar.cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SakitPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[.//p[text()='Sakit']]")
    private WebElement HeaderSakit;

    @FindBy(xpath = "//button[contains(text(),'Ajukan Sakit')]")
    private WebElement buttonAjukanSakit;

    @FindBy(css = "svg.MuiSvgIcon-root.MuiSvgIcon-colorPrimary")
    private WebElement buttonIconCalender;

    @FindBy(xpath = "//button[normalize-space()='Simpan']")
    private WebElement buttonSimpanTanggal;

    @FindBy(xpath = "//button[contains(@class,'css-1ty6hmy')]")
    private WebElement buttonUploadFile;

    @FindBy(css = "button[type='submit'].MuiButton-containedPrimary")
    private WebElement buttonAjukanFinal;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div")
    private WebElement messageSucces;

    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message') and contains(text(), 'izin sakit')]")
    private WebElement messageError;

    @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and contains(text(),'Incorrect datetime value')]")
    private WebElement messageError2;

    @FindBy(xpath = "//button[contains(text(),'Reset')]")
    private WebElement reset;

    @FindBy(xpath = "//div[contains(@class,'MuiBox-root')]//p[normalize-space(.)='/']")
    private WebElement formEmpty;

    @FindBy(xpath = "//p[contains(text(),'Total')]")
    private WebElement totalReqListsSakit;

    public SakitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buttonAjukanSakit(){
        buttonAjukanSakit.click();
    }

    public void buttonIconCalender(){
        buttonIconCalender.click();
    }

    public void pilihTanggal(String tanggal) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tanggalElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[normalize-space()='" + tanggal + "' and not(@tabindex='-1')]")
        ));
        tanggalElement.click();
    }

    public void buttonSimpanTanggal(){
        buttonSimpanTanggal.click();
    }

    public void uploadBuktiSakit(String filePath){
        buttonUploadFile.sendKeys(filePath);
    }

    public void ajukanfinal(){
        buttonAjukanFinal.click();
    }

    public void buttonResetForm() {
        reset.click();
    }

    public boolean isHeaderSakitPage(){
        return HeaderSakit.isDisplayed();
    }

    public boolean messageSucces(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageSucces));
        return messageSucces.isDisplayed();
    }

    public int getTotalReqSakit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(totalReqListsSakit));
        String rawText = totalReqListsSakit.getText();
        String total = rawText.replaceAll("[^0-9]", "");
        return Integer.parseInt(total);
    }

    public boolean formEmptyVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(formEmpty));
        return formEmpty.isDisplayed();
    }

    public String getMessageError2Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageError2));
        return messageError2.getText();
    }

    public String getMessage(){
        return messageError.getText();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    
}
