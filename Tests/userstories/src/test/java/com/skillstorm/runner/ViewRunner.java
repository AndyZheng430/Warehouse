package com.skillstorm.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", features = {"src/test/resources/com/skillstorm/features/viewfeatures"}, 
glue = {"com.skillstorm.definitions.viewdefinitions"},
                 plugin = {"pretty"})
public class ViewRunner extends AbstractTestNGCucumberTests{
   
}