package com.skillstorm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features/updatefeatures"}, 
glue = {"com.skillstorm.definitions.updatedefinitions"},
                 plugin = {"pretty"})
public class UpdateRunner extends AbstractTestNGCucumberTests{
    
}
