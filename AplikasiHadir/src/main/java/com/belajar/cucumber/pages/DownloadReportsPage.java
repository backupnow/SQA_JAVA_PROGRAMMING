package com.belajar.cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadReportsPage {

    private WebDriver driver;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-15et00z")
    private WebElement getMessage;

    @FindBy(xpath = "//p[contains(text(), 'Kembali')]")
    private WebElement btnback;

    @FindBy(id = "mui-component-select-share_report")
    private WebElement dropDownReport;

    @FindBy(xpath = "//button[.//p[text()='Download Report']]")
    private WebElement btndownload;

    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message')]")
    private WebElement messageDownload;

    @FindBy(xpath = "//*[text()='Tipe report harus dipilih!']")
    private WebElement messageError;

    public DownloadReportsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessagepage() {
        return getMessage.getText();
    }

    public String getMessageDownload() {
        return messageDownload.getText();
    }

    public String getMessageError() {
         return messageError.getText();
    }

    public void buttonBack() {
        btnback.click();
    }

    public void dropDownTipeReport() {
        dropDownReport.click();
    }

    public void pilihTipeReport(String tipe) {
        dropDownReport.click();
        WebElement opsi = new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + tipe + "']")));
        opsi.click();
    }

    public void buttonDownloadReports() {
        btndownload.click();
    }

    public void klikDownloadReport() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiBackdrop-root")));
        driver.findElement(By.xpath("//button[.//p[text()='Download Report']]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
