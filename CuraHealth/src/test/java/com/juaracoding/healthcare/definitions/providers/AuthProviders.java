package com.juaracoding.healthcare.definitions.providers;

import org.openqa.selenium.WebDriver;

import com.juaracoding.healthcare.pages.DashboardPage;
import com.juaracoding.healthcare.pages.LoginPage;
import com.juaracoding.healthcare.utils.DriverManager;

public class AuthProviders {

    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private DriverManager driverManager;
    protected WebDriver driver;


    public DashboardPage dashboardPage(){
        dashboardPage = new DashboardPage(driver);
        return dashboardPage;
    }

    public LoginPage loginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public WebDriver getDriver(){
        return driverManager.getDriver();
       
    }

    public void preTest(){
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    public void preConditionLogin(){
        preTest();
        dashboardPage().btnMakeAppointment();
        loginPage = new LoginPage(driver);
        loginPage.loginPerform();
        
    }

    public void preConCekBox() throws InterruptedException{
        dashboardPage().ceklisReadmisson();
        Thread.sleep(2000);
        dashboardPage().ceklisButtonHealthProgram();
    }

    public void close(){
        driverManager.quitDriver();
    }
    
}
