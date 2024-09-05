package com.skillstorm.definitions.adddefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.skillstorm.pages.WarehousePage;
import com.skillstorm.helper.ResetDB;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddWarehouseSteps {
    
    private WebDriver driver;

    private WarehousePage warehousePage;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-headless");
        driver = new ChromeDriver(options);
        warehousePage = new WarehousePage(driver);
        ResetDB.sendPost();
    }

    @After
    public void after () {
        if(driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the warehouse page")
    public void onTheWarehousePage() {
        warehousePage.getMain();
        warehousePage.travelWarehouse();
    }

    @When("I click the create button")
    public void clickTheCreateButton() {
        warehousePage.clickCreate();
    }

    @And("enter a valid warehouse name")
    public void enterValidWarehouseName() {
        warehousePage.setWarehouseNameField("Warehouse");
    }

    @And("enter a valid location")
    public void enterValidLocation() {
        warehousePage.setWarehouseLocation("Location");
    }

    @And("enter a valid owner")
    public void enterValidOwner() {
        warehousePage.setWarehouseOwner("Owner");
    }

    @And("enter a valid capacity")
    public void enterValidCapacity() {
        warehousePage.setWarehouseCapacity("100");
    }

    @And("enter a capacity less than 0") 
    public void enterCapacityLessThanZero() {
        warehousePage.setWarehouseCapacity("-1");
    }

    @And("I click the submit button")
    public void clickTheSubmitButton() {
        warehousePage.clickSubmit();
    }

    @Then("create a new warehouse with the name, owner, location, and capacity")
    public void CreateANewWarehouse() {
        Boolean isPresent = driver.findElements(By.xpath("//div[text()='Warehouse']")).size() > 0;
        assertTrue(isPresent);
    }

    @Then("a new warehouse should not be created")
    public void warehouseNotCreated() {
        Boolean isPresent = driver.findElements(By.xpath("//div[text()='Warehouse']")).size() > 0;
        assertFalse(isPresent);
    }
}
