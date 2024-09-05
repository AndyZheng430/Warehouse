package com.skillstorm.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = ("@testing"), features = {"src/test/resources/com/skillstorm/features/viewfeatures"}, 
glue = {"com.skillstorm.definitions.viewdefinitions"},
                 plugin = {"pretty"})
public class ViewRunner extends AbstractTestNGCucumberTests{
   
}