package com.juaracoding.healthcare.definitions.authentications;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.juaracoding.healthcare.definitions.providers.AuthProviders;
import com.juaracoding.healthcare.utils.ScenarioContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
  
    public static AuthProviders driver;
    public static ExtentReports extent;

  @After
  public void tearDown(Scenario scenario) {
    final byte[] screenshot = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", scenario.getName());  
    if (driver != null) {
        driver.close();
        driver = null; // Optional: clear the reference
    }
    
  }
  
  @Before
  public void beforeScenario(Scenario scenario) {
      ScenarioContext.setScenario(scenario);
  }

  @AfterAll
  public static void flushReport() {
      if (extent != null) {
          extent.createTest("Smoke Test").pass("Pipeline berhasil dijalankan");
          extent.flush();
      }
  }


    
}
