package com.juaracoding.healthcare.definitions.providers;

import org.openqa.selenium.WebDriver;

import com.juaracoding.healthcare.pages.DashboardPage;
import com.juaracoding.healthcare.pages.HistoryPage;
import com.juaracoding.healthcare.pages.LoginPage;
import com.juaracoding.healthcare.pages.ProfilePage;
import com.juaracoding.healthcare.utils.DriverManager;
import com.juaracoding.healthcare.utils.ScrollUpDown;

public class AuthProviders {

    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private DriverManager driverManager;
    protected WebDriver driver;
    private ScrollUpDown scrollUpDown;
    private HistoryPage historyPage;
    private ProfilePage profilePage;

    public DashboardPage dashboardPage() {
        dashboardPage = new DashboardPage(driver);
        return dashboardPage;
    }

    public LoginPage loginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public HistoryPage historyPage() {
        historyPage = new HistoryPage(driver);
        return historyPage;
    }

    public ProfilePage profilePage() {
        profilePage = new ProfilePage(driver);
        return profilePage;
    }

    public ScrollUpDown scrollDown() {
        if (scrollUpDown == null) {
            scrollUpDown = new ScrollUpDown(driver, dashboardPage());
        }
        return scrollUpDown;
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
       
    }

    public void preTest() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    public void preConditionLogin() {
        preTest();
        dashboardPage().btnMakeAppointment();
        loginPage = new LoginPage(driver);
        loginPage.loginPerform();
        
    }

    public void preMenuToggle() throws InterruptedException {
        preTest();
        dashboardPage().btnMakeAppointment();
        loginPage().loginPerform();
        Thread.sleep(1000);
        loginPage().clickMenuToggle();
        Thread.sleep(2000);
    }

    public void preConCekBox() throws InterruptedException{
        dashboardPage().ceklisReadmisson();
        Thread.sleep(2000);
        dashboardPage().ceklisButtonHealthProgram();
    }

    public void close() {
        driverManager.quitDriver();
    }
    
}
