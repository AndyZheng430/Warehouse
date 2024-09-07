package com.skillstorm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features/addfeatures"}, 
glue = {"com.skillstorm.definitions.adddefinitions"},
                 plugin = {"pretty"})
public class AddRunner extends AbstractTestNGCucumberTests{
    
}
