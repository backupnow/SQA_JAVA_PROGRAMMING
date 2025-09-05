package com.juaracoding.healthcare.definitions;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports createInstance() throws IOException {
        String env = System.getenv("JENKINS_HOME");
        String reportPath;

        if (env != null) {
            reportPath = "target/ExtentReports/Spark_Jenkins.html";
        } else {
            reportPath = "target/ExtentReports/Spark_Local.html";
        }

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.loadXMLConfig("src/test/resources/extent-config.xml");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
}
