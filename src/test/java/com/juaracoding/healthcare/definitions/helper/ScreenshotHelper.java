package com.juaracoding.healthcare.definitions.helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.juaracoding.healthcare.definitions.authentications.Hook;
import com.juaracoding.healthcare.utils.ScenarioContext;

import io.cucumber.java.Scenario;


public class ScreenshotHelper {

   public static void captureInputScreenshot(String label) {
        Scenario scenario = ScenarioContext.getScenario();
        byte[] screenshot = ((TakesScreenshot) Hook.driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot - " + label);
    }

}
