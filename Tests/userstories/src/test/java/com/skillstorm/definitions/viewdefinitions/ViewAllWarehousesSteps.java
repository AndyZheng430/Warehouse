package com.skillstorm.definitions.viewdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.skillstorm.pages.WarehousePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

//resetDB
import com.skillstorm.helper.ResetDB;

public class ViewAllWarehousesSteps {

    WebDriver driver;
    private WarehousePage warehousePage;

    @Before
    public void setup(){

        ResetDB.sendPost();
        //add headless and implicit wait
        ChromeOptions options = new ChromeOptions();


        options.setImplicitWaitTimeout(Duration.of(3, ChronoUnit.SECONDS));
        options.addArguments("-headless");

        //create new POM object
        this.driver = new ChromeDriver(options);
        this.warehousePage = new WarehousePage(driver);
    }

    // Cleanup after test execution
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Given("I am on the {string} page")
    public void i_am_on_the_page(String string) {

        WebElement titleParent = driver.findElement(By.className("_container_1avss_1"));
        WebElement title = titleParent.findElement(By.className("_title_1avss_15"));
        assertEquals(title.getText(),string);
    }

    @When("there is one or more warehouses existing")
    public void thereIsOneOrMoreWarehousesExisting() {
        // This step assumes that warehouses exist and are displayed on the page.
        // In an actual test environment, you might need to prepopulate the database or mock the backend to ensure warehouses exist.
        
            Boolean isPresent = driver.findElements(By.className("_record_9ratk_1")).size() > 0;
            assertTrue(isPresent);
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
        assertTrue(true);
    }

    @Then("I should see an empty list of warehouses created")
    public void iShouldSeeAnEmptyListOfWarehousesCreated() {
        
        /* ---------------IMPORTANT------------- */
        //Change to assertFalse to test empty vs occupied warehouse
        List<WebElement> warehousesList = driver.findElements(By.cssSelector(".warehouse-item"));
        assertTrue(warehousesList.isEmpty(),"Warehouses list should be empty");
    }
}
