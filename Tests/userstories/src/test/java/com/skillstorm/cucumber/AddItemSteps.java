package com.skillstorm.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.Selenium.ItemsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemSteps {
    

private WebDriver driver;
private ItemsPage itemsPage;


@Before("@addItem")
public void before(){
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    this.driver = new ChromeDriver();
    this.itemsPage = new ItemsPage(driver);
}

 @After("@addItem")
    public void after() {
        if(driver != null) {
            this.driver.quit();
        }
    }
@Given("I am on the items page")
public void IAmOnTheLogInPage(){
    this.itemsPage.getMain();
    this.itemsPage.travelItems();
    
}

@When("I click create")
public void IClickCreate(){
    this.itemsPage.clickCreate();
}

@And("I enter a item name and a item description")
public void iEnterItemNameAndItemDescription(){
    this.itemsPage.setItemName("watch");
    this.itemsPage.setItemDescription("Smartwatch");
}

@And("I enter a item description")
public void ienterItemDescription(){
    this.itemsPage.setItemDescription("really really really cool");
}

@And("I click submit")
public void iCLickSubmit(){
    this.itemsPage.clickSubmit();
}

@Then("an item should be created and added to the database")
public void shouldAddItem(){
    System.out.println("need implemented");
}

@Then("an item should not be created and added to the database")
public void shouldNotAddItem(){
    System.out.println("needs implemented");
}
}

