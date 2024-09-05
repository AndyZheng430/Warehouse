package com.skillstorm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features/navigatefeatures"}, 
glue = {"com.skillstorm.definitions.navigatedefinitions"},
                 plugin = {"pretty"})
public class NavigateRunner extends AbstractTestNGCucumberTests{
    
}
