package com.skillstorm.definitions.updatedefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillstorm.pages.WarehousePage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class UpdateInventorySteps {
    
    WebDriver driver;
    WebDriverWait wait;
    WebElement clicktoEdit;
    private WarehousePage warehousePage;

    @Before
    public void setup() {
        // Initialize WebDriver instance
        ChromeOptions options = new ChromeOptions();

        options.setImplicitWaitTimeout(Duration.of(3, ChronoUnit.SECONDS));
        options.addArguments("-headless");
        
        //options.addArguments("-headless");
        this.driver = new ChromeDriver(options);
        this.warehousePage = new WarehousePage( this.driver);
    }

    @Given("I am on {string} page")
    public void i_am_on_the_warehouses_page(String string) {
        
        this.warehousePage.getMain();
        assertEquals(this.warehousePage.getTitle(),string);
    }

    @And("I have existing warehouse with the following details:")
    public void i_expand_a_warehouse_s_details(Map<String,String> detailsTable) {

        String name = detailsTable.get("Name");
        String location = detailsTable.get("Location");
        String owner = detailsTable.get("Owner");
        String capacity = detailsTable.get("Capacity");

        assertTrue(warehousePage.findWarehouse(name, location, owner, capacity));
    }

    @When("I click to edit item:")
    public void i_click_to_edit_an_item(Map<String,String> details) {
        WebElement row = driver.findElement(By.className("inventory-1-1"));
        WebElement editButton = row.findElement(By.className("undefined _option_do5oz_77"));
        editButton.click();
    }

    @Then("a window should display the item Id {string} and amount {string}")
    public void a_window_should_display_the_item_id_and_amount(String string, String string2) {
        // WebElement itemId = driver.findElement(By.id("item-id"));
        // WebElement itemQuantity = driver.findElement(By.id("inventory-amount"));
        // assertTrue(itemId.isDisplayed(), "Item name should be displayed.");
        // assertTrue(itemQuantity.isDisplayed(), "Item quantity should be displayed.");
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 
     * SECOND SCENARIO
     * 
     */
    ///////////////////////////////////////////////////////////////////////////////////////////


    @Given("I click to edit item named {string}")
    public void i_click_to_edit_item_named(String itemName) {

        driver.findElement(By.xpath("//div[text()='" + "Woodshop" + 
        "']/ancestor::div[contains(@class, '_record_9ratk_1')]//div[contains(@class, '_option_9ratk_111')]")).click();

        WebElement expandEditButton = driver.findElement(By.xpath("//div[text()='" + itemName + 
        "']/ancestor::div[contains(@class, '_record_9ratk_1')]//div[contains(@class, '_edit_9ratk_71') and contains(@class, '_option_9ratk_39')]"));
        expandEditButton.click();
    }

    @When("I change the inventory item Id to {string}")
    public void i_change_the_inventory_item_id_to(String newItemId) {
        WebElement itemIdField = driver.findElement(By.id("item-id"));
        itemIdField.clear();
        itemIdField.sendKeys(newItemId);
    }

    @And("I change the quantity to {string}")
    public void i_change_the_quantity_to(String newQuantity) {
        WebElement quantityField = driver.findElement(By.id("inventory-quantity"));
        quantityField.clear();
        quantityField.sendKeys(newQuantity);
    }

    @Then("the item name should be updated to:")
    public void the_item_name_should_be_updated_to(List<Map<String,String>> details) {
        // WebElement itemName = driver.findElement(By.id("item-name"));
        // assertEquals(details, itemName.getText(), "Item name should be updated.");
    }

    //OOS

    // @And("the amount should be updated to {string}")
    // public void the_amount_should_be_updated_to(String expectedAmount) {
    //     WebElement itemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-quantity")));
    //     assertEquals(expectedAmount, itemQuantity.getText(), "Item quantity should be updated.");
    // }

    // @Then("I should receive an error message")
    // public void i_should_receive_an_error_message() {
    //     WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
    //     assertTrue(errorMessage.isDisplayed(), "Error message should be displayed.");
    // }

    // @And("the inventory item should not be updated")
    // public void the_inventory_item_should_not_be_updated() {
    //     // Check that the inventory item has not been updated (implementation depends on your application's behavior)
    // }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
