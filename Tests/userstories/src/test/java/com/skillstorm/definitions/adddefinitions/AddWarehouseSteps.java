package com.skillstorm.definitions.adddefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import com.skillstorm.Selenium.WarehousePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddWarehouseSteps {
    
    private WebDriver driver;
    private WebDriverWait wait;

    private WarehousePage warehousePage;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("-headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        warehousePage = new WarehousePage(driver);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),' Create')]")));
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        warehousePage.clickSubmit();
    }

    @Then("create a new warehouse with the name, owner, location, and capacity")
    public void CreateANewWarehouse() {
        Boolean isPresent = driver.findElements(By.xpath("//div[text()='Warehouse']")).size() > 0;
        assertTrue(isPresent);
    }
}
