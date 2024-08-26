package com.skillstorm.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features"}, glue = {"com.skillstorm.stepdefinitions"},
                 plugin = {})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}