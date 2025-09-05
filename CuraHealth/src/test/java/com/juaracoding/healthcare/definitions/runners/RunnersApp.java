package com.juaracoding.healthcare.definitions.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {
        "src/test/resources/features/AuthCuraHealth.feature",
        "src/test/resources/features/curahealt.feature",
        "src/test/resources/features/History.feature",
        "src/test/resources/features/Profile.feature"
}, glue = {
         "com.juaracoding.healthcare.definitions.authentications",
         "com.juaracoding.healthcare.definitions.orders",
         "com.juaracoding.healthcare.definitions.scroll",
         "com.juaracoding.healthcare.definitions.history",
         "com.juaracoding.healthcare.definitions.profile"
}, plugin = {
        "pretty",  
        "html:target/cucumber-reporting/reports.html", 
        "json:target/cucumber-reporting/reports.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunnersApp extends AbstractTestNGCucumberTests {
    
}
