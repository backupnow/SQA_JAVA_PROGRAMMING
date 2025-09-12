package com.belajar.cucumber.sideBar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePass {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Change Password']")
    private WebElement changePass;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(id = "passwordConfirmation")
    private WebElement inputConfirm;

    @FindBy(xpath = "//button[contains(text(), 'Confirm New Password')]")
    private WebElement btnConfir;

    @FindBy(xpath = "//p[text()='Sukses mengganti password']")
    private WebElement messageSuccess;

    @FindBy(xpath = "//button[text()='Oke']")
    private WebElement okMessage;

    @FindBy(xpath = "(//p[contains(@class, 'MuiFormHelperText-root')])[1]")
    private List<WebElement> messagepass;

    @FindBy(xpath = "//p[contains(@class, 'MuiFormHelperText-root')]")
    private List<WebElement> errorMessages;

    @FindBy(xpath = "//p[contains(text(), 'Passwords must match')]")
    private List<WebElement> messageConfirm;

    public ChangePass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changePassword() {
        changePass.click();
    }

    public void inputPass(String value) {
         inputPass.sendKeys(value);
    }

    public void inputConfirm(String value) {
        inputConfirm.sendKeys(value);
    }

    public void buttonConfirm() {
        btnConfir.click();
    }

    public String messageSuccess() {
        return messageSuccess.getText();
    }

    public void okMessage() {
        okMessage.click();
    }

    public String getPasswordErrorMessage() {
        String passwordValue = inputPass.getAttribute("value").trim();
        String confirmValue = inputConfirm.getAttribute("value").trim();

        if (passwordValue.isEmpty()) {
            return inputPass.getAttribute("validationMessage").trim();
        }

        if (confirmValue.isEmpty()) {
            return "";
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(driver -> errorMessages.size() >= 1 && errorMessages.get(0).isDisplayed());
            return errorMessages.get(0).getText().trim();
        } catch (Exception ignored) {
            return "";
        }
    }

    public String getConfirmPasswordErrorMessage() {
        String passwordValue = inputPass.getAttribute("value").trim();
        String confirmValue = inputConfirm.getAttribute("value").trim();

        if (passwordValue.isEmpty()) {
            return "";
        }

        if (confirmValue.isEmpty()) {
            return inputConfirm.getAttribute("validationMessage").trim();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(driver -> errorMessages.size() >= 2 && errorMessages.get(1).isDisplayed());
            return errorMessages.get(1).getText().trim();
        } catch (Exception ignored) {
            return "";
        }
    }

    
}
