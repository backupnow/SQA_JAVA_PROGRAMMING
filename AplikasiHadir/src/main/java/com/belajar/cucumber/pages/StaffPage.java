package com.belajar.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffPage {

    private WebDriver driver;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1m443p8")
    private WebElement message;

    @FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-root')])[1]")
    private WebElement btnBack;

    public StaffPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String messagePage() {
        return message.getText();
    }

    public void buttonBack() {
        btnBack.click();
    }
    
}
