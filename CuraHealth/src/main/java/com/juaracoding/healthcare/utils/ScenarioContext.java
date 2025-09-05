package com.juaracoding.healthcare.utils;

import io.cucumber.java.Scenario;

public class ScenarioContext {

    private static Scenario scenario;
    
    public static void setScenario(Scenario sc) {
        scenario = sc;
    }

    public static Scenario getScenario() {
        return scenario;
    }
    
}
