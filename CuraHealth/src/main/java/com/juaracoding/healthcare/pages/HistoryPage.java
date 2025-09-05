package com.juaracoding.healthcare.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.healthcare.extends_page.BasePage;

public class HistoryPage extends BasePage {


    @FindBy(xpath = "//a[text()='History']")
    private WebElement btnHistory;

    @FindBy(xpath = "//h2[text()='History']")
    private WebElement messagePage;

    @FindBy(xpath = "//a[normalize-space(text())='Go to Homepage']")
    private WebElement goToHome;

    @FindBy(xpath = "//p[text()='No appointment.']")
    private WebElement messageHistoryNull;
    
    @FindBy(xpath = "//div[@class='panel-heading']")
    private List<WebElement> appointmentDates;

    @FindBy(xpath = "//div[@class='col-sm-2']/label")
    private List<WebElement> historyLabels;

    @FindBy(xpath = "//div[@class='col-sm-10']")
    private List<WebElement> historyValues;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public void buttonHistory() {
       btnHistory.click();
    }

    public void buttonGoHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(goToHome));
        goToHome.click();
    }

    public String messageHistory() {
        return messagePage.getText();
    }

    public String messageNoData() {
        return messageHistoryNull.getText();
    }

    public boolean isAtHistoryPage() {
        return getCurrentURL1().contains("/history.php");
    }

    // for getElement Date with diferent by input
    public boolean isDateVisible(String expectedDate) {
        for(WebElement date : appointmentDates) {
            if (date.getText().trim().equals(expectedDate)) {
                return date.isDisplayed();
            }
        }
        return false;
    }

    public boolean isAtHistoryHero() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlToBe("https://katalon-demo-cura.herokuapp.com/"));
    }

    //for getElement Labels & Values with diferent by input
    public boolean isHistoryFieldUniversal(String label, String expectedValue) {
        for (int i = 0; i < historyLabels.size(); i++) {
            String currentLabel = historyLabels.get(i).getText().trim();
            String currentValue = historyValues.get(i).getText().trim();
            if (currentLabel.equalsIgnoreCase(label)) {
                return currentValue.equals(expectedValue);
            }
        }
        return false;
    }

    
}
