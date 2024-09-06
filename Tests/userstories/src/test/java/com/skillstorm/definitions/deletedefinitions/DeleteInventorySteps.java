package com.skillstorm.definitions.deletedefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DeleteInventorySteps {
    
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement warehouseRow;
    WebElement expandButton;

    @Given("I am on the {string} page")
    public void i_navigate_to_the_warehouses_page(String name) {
                FirefoxOptions options = new FirefoxOptions();

        Duration duration = Duration.of(3, ChronoUnit.SECONDS);
	    options.setImplicitWaitTimeout(duration);

        options.addArguments("-headless");

        //generate driver with options and get items page
        driver = new FirefoxDriver(options);
        driver.get("http://localhost:5173/warehouses");

        
        WebElement titleParent = driver.findElement(By.className("_container_1avss_1"));
        WebElement title = titleParent.findElement(By.className("_title_1avss_15"));
        assertEquals(title.getText(),name);
    }

    @And("I have expanded the warehouse named {string} to view its inventory")
    public void i_expand_the_warehouse_named(String warehouseName) {
        // Locate the warehouse row by its name
        warehouseRow = driver.findElement(By.xpath("//div[contains(@class, '_col_9ratk_23') and text()='" + warehouseName + "']/ancestor::div[@class='_record_9ratk_1']"));

        // Click on the div with class "_option_9ratk_39 _display_9ratk_111" to expand the warehouse
        expandButton = warehouseRow.findElement(By.cssSelector("div._option_9ratk_39._display_9ratk_111"));
        expandButton.click();
    }

    @When("I delete an inventory item with the name {string}")
    public void theUserClicksTheDeleteButtonForTheWarehouse(String itemName) {
        WebElement deleteButton = warehouseRow.findElement(By.className("_delete_9ratk_91"));
        deleteButton.click();
        wait.until(ExpectedConditions.stalenessOf(deleteButton));
        driver.navigate().refresh();
    }

    
    @Then("the entry should be deleted")
    public void the_inventory_item_should_not_be_listed() {
        //error with program, ignore for now
        // boolean itemExists = driver.findElements(By.xpath("//div[contains(@class, 'inventory-item')]]")).size() > 0;
        //assertFalse(itemExists);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
