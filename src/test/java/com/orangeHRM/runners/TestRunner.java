package com.orangeHRM.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.orangeHRM.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "summary",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
