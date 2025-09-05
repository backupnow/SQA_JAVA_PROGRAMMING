package com.juaracoding.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Profile']")
    private WebElement btnProfile;

    @FindBy(xpath = "//p[text()='Under construction.']")
    private WebElement messageProfile;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void btnMenuProfile() {
        btnProfile.click();
    }

    public String messageConfirProfile() {
        return messageProfile.getText();
    }

}
