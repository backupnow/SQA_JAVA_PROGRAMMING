package com.juaracoding.healthcare.definitions.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {
        "src/test/resources/features/curahealt.feature"
}, glue = {
        "com.juaracoding.healthcare.definitions.authentications",
         "com.juaracoding.healthcare.definitions.orders"
}, plugin = {
        "pretty",  
        "html:target/cucumber-reporting/reports.html", 
        "json:target/cucumber-reporting/reports.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class RunnersApp extends AbstractTestNGCucumberTests {
    
}
