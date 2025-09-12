package com.belajar.cucumber.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IzinPage {

    private WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Izin']")
    private WebElement headerIzin;

    @FindBy(css = "svg[data-testid='AccessAlarmIcon']")
    private WebElement clickIconJam;

    @FindBy(css = "textarea#notes")
    private WebElement inputKeterangan;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement klikOkCalender;

    @FindBy(xpath = "//button[contains(text(),'Ajukan Izin Terlambat')]")
    private WebElement buttonAjukanTerlambat;

    @FindBy(xpath = "//button[contains(text(),'Ajukan Pulang Cepat')]")
    private WebElement buttonAjukanPulangCepat;

    @FindBy(xpath = "//button[@aria-current='date']")
    private WebElement inputTanggalField;
    
    @FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
    private WebElement getDateElementReset;

    @FindBy(xpath = "//button[text()='Reset']")
    private WebElement btnReset;

    @FindBy(css = "div.MuiPickersCalendarHeader-label")
    private WebElement calenderHeader;

    @FindBy(css = "button.MuiIconButton-root svg.MuiSvgIcon-root")
    private WebElement calendarIcon;

    @FindBy(xpath = "//button[text()='Ajukan']")
    private WebElement buttonFinalAjukan;

    @FindBy(xpath = "//p[contains(text(),'Tanggal Harus diisi')]")
    private WebElement messageTanggal;

    @FindBy(xpath = "//p[contains(text(),'Keterangan Harus diisi')]")
    private WebElement messageNote;

    @FindBy(xpath = "//button[contains(@class, 'MuiTab-root') and text()='Pulang Cepat']")
    private WebElement tabPulangCepat;

    @FindBy(xpath = "//button[contains(@class, 'MuiTab-root') and text()='Terlambat']")
    private WebElement tabTerlambat;
    
    @FindBy(xpath = "//p[text()='Kembali']")
    private WebElement tabBack;

    @FindBy(xpath = "//p[contains(text(), 'Total :')]")
    private WebElement totalListIzin;

    public IzinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iconJam(){
        clickIconJam.click();
    }
   
    public void buttonAjukanTerlambat(){
        buttonAjukanTerlambat.click();
    }

    public void buttonAjukanCepat() {
        buttonAjukanPulangCepat.click();
    }

    public void btnTabTerlambat() {
        tabTerlambat.click();
    }

    public void btnTabPulangCepat() {
        tabPulangCepat.click();
    }

    public void buttonBack() {
        tabBack.click();
    }

    public void inputKeterangan(String teks){
        inputKeterangan.sendKeys(teks);
    }

    public void pilihTanggal(String date) {
        inputTanggalField.sendKeys(date);
    }

    public void inputTanggal(String date) {
        WebElement tanggalElement = driver.findElement(By.xpath("//button[text()='" + date + "']"));
        tanggalElement.click();
    }

    public String calenderHeader() {
        return calenderHeader.getText();
    }

   public String getInputKeterangan() {
        return inputKeterangan.getAttribute("value");
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean isIzinPageDisplayed() {
        return headerIzin.isDisplayed();
    }

    public void buttonAjukanFinish() {
        buttonFinalAjukan.click();
    }

    public void btnOKCalender() {
        klikOkCalender.click();
    }

    public void buttonReset() {
        btnReset.click();
    }

    public String pesanTanggal(){
        return messageTanggal.getText();
    }

    public String pesanNote(){
        return messageNote.getText();
    }

    public String dateNotReset() {
        return getDateElementReset.getAttribute("value");
    }

    public String getValueByLabel(String labelText) {
        List<WebElement> labels = driver.findElements(By.xpath("//div[@class='MuiBox-root css-d2rcfq']/p"));
        List<WebElement> values = driver.findElements(By.xpath("//div[@class='MuiBox-root css-1sa3tdi']/p"));

        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getText().trim().equalsIgnoreCase(labelText)) {
                return values.get(i).getText().replace(": ", "").trim();
            }
        }
        return null; // jika label tidak ditemukan
    }

    public void clickIconJam() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iconJam = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("svg.MuiSvgIcon-root.MuiSvgIcon-colorPrimary")));
        iconJam.click();
    }

    public void clickIconCalender() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iconCalender = wait.until(ExpectedConditions.elementToBeClickable(calendarIcon));
        iconCalender.click();
    }

    public int getTotalListIzin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(totalListIzin));
        String rawText = totalListIzin.getText();
        String total = rawText.replaceAll("[^0-9]", "");
        return Integer.parseInt(total);
    }
}

