package com.juaracoding.healthcare.extends_page;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

     // inisialisasi wajib jika memakai @FindBy
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentURL1() {
        return driver.getCurrentUrl();
    }
    
}
