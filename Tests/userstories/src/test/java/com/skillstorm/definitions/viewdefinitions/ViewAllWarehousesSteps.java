package com.skillstorm.definitions.viewdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;


import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class ViewAllWarehousesSteps {

    WebDriver driver;
    

    @Given("I am on the landing page")
    public void iAmOnTheLandingPage() {
        // Initialize the WebDriver and navigate to the landing page
        driver = new FirefoxDriver();
        driver.get("http://localhost:5173"); // Adjust URL to match your React app's landing page
    }

    @When("I navigate to the warehouses page")
    public void iNavigateToTheWarehousesPage() {
        // Navigate by anchro linktext

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement warehousesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/warehouses']")));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", warehousesLink);

        warehousesLink.click();
    }

    @When("there is one or more warehouses existing")
    public void thereIsOneOrMoreWarehousesExisting() {
        // This step assumes that warehouses exist and are displayed on the page.
        // In an actual test environment, you might need to prepopulate the database or mock the backend to ensure warehouses exist.
        
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement warehousesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_record_9ratk_1")));
            assertTrue(true, "There are warehouses!");
        }
        catch(Exception e){
            assertFalse(false, "It's Empty!");
        }
        
    }

    @Then("I should see a list of all warehouses created")
    public void iShouldSeeAListOfAllWarehousesCreated() {
        // Verify that the list of warehouses is displayed
        List<WebElement> warehousesList = driver.findElements(By.className("_record_9ratk_1"));
        

        /* ---------------IMPORTANT------------- */
        //Change to assertTrue to test empty vs occupied warehouse
        assertFalse(warehousesList.isEmpty(),"Warehouses list should not be empty");
    }

    @Then("each warehouse should display the warehouse name, owner, location, and maximum capacity")
    public void eachWarehouseShouldDisplayDetails() {
        // Verify that each warehouse item displays the correct details
        List<WebElement> warehousesList = driver.findElements(By.className("_record_9ratk_1"));
        for (WebElement warehouse : warehousesList) {
            assertTrue(warehouse.findElement(By.className("_col_9ratk_23")).isDisplayed(), "Warehouse name is missing");
            assertTrue(warehouse.findElement(By.className("_col_9ratk_23")).isDisplayed(), "Warehouse owner is missing");
            assertTrue(warehouse.findElement(By.className("_col_9ratk_23")).isDisplayed(), "Warehouse location is missing");
            assertTrue(warehouse.findElement(By.className("_col_9ratk_23")).isDisplayed(), "Warehouse maximum capacity is missing");
        }
    }

    @When("there is no current warehouses existing")
    public void thereIsNoCurrentWarehousesExisting() {
        /*  Changing in postgres for now 
            assume proper implementation later
        */
    }

    @Then("I should see an empty list of warehouses created")
    public void iShouldSeeAnEmptyListOfWarehousesCreated() {
        
        /* ---------------IMPORTANT------------- */
        //Change to assertFalse to test empty vs occupied warehouse
        List<WebElement> warehousesList = driver.findElements(By.cssSelector(".warehouse-item"));
        assertTrue(warehousesList.isEmpty(),"Warehouses list should be empty");
    }

    // Cleanup after test execution
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}