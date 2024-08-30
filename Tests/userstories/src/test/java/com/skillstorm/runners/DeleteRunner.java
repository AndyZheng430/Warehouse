package com.skillstorm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features/deletefeatures"}, 
glue = {"com.skillstorm.definitions.deletedefinitions"},
                 plugin = {"pretty"})
public class DeleteRunner extends AbstractTestNGCucumberTests{
    
}
