package com.juaracoding.healthcare.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "txt-username")
    private WebElement emailLogin;

    @FindBy(id = "txt-password")
    private WebElement passwordLogin;

    @FindBy(id = "btn-login")
    private WebElement buttonLogin;

    @FindBy(id = "menu-toggle")
    private WebElement btnMenuToggle;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement btnLogout;

    @FindBy(xpath = "//h3[text()='We Care About Your Health']")
    private WebElement healthMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-danger')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver, this);
  }

  public void setEmailLogin(String value) {
    emailLogin.sendKeys(value);
  }

  public void setPasswordLogin(String value) {
    passwordLogin.sendKeys(value);
  }

  // tambahan
  public void setUsername(String username) {
    emailLogin.sendKeys(username);
  }

  public void setPassword(String password) {
    passwordLogin.sendKeys(password);
  }

  public void buttonLogin() {
    buttonLogin.click();
  }

  public void buttonLogOut() {
    btnLogout.click();
  }

  public String messageHealth() {
    return healthMessage.getText();
  }

  public void clickMenuToggle() {
    btnMenuToggle.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(ExpectedConditions.visibilityOf(btnMenuToggle));
  }

  // jika tidak ketutup otomatis
  public void closeMenuToggle() {
    if (btnMenuToggle.isDisplayed()) {
      btnMenuToggle.click();
    }
  }

  public void loginPerform() {
    setEmailLogin("John Doe");
    setPasswordLogin("ThisIsNotAPassword");
    buttonLogin();
  }

  public void loginPerform(String username, String password){
    setEmailLogin(username);
    setPasswordLogin(password);
    buttonLogin();
  }

  public void clickLoginButton() {
    buttonLogin.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("/#appointment"));
  }

  public String waitMessageHealth() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOf(healthMessage));
    return healthMessage.getText();
  }

  public String messageError() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOf(errorMessage));
    return errorMessage.getText();
  }

    
}
