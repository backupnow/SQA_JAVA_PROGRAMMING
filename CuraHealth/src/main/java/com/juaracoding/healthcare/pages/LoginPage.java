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

  public void buttonLogin(){
    buttonLogin.click();
  }

  public void loginPerform(){
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
    
}
