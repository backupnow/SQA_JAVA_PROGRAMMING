package com.juaracoding.healthcare.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.healthcare.pages.DashboardPage;

public class ScrollUpDown {

    private WebDriver driver;
    private DashboardPage dashboardPage;

    public ScrollUpDown(WebDriver driver, DashboardPage dashboardPage) {
        this.driver = driver;
        this.dashboardPage = dashboardPage;
    }

    // Scroll Efect
    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    // Scroll ke Appointment Section
    public void navigateToAppointment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getAppointmentSection()));
        scrollTo(dashboardPage.getAppointmentSection());
    }

    // Scroll ke Book Appointment Section
    public void navigateToBookAppointment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getBookSection()));
        scrollTo(dashboardPage.getBookSection());
    }

    // Scroll ke Twitter section
    public void NavigateToTwittScroll() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.getTwittScroll()));
        scrollTo(dashboardPage.getTwittScroll());
    }
}
