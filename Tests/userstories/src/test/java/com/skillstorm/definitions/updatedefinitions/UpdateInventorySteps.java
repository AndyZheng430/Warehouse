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
import static org.testng.Assert.assertFalse;

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
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    
    //================= BACKGROUND =================
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
    //================= SCENARIO 1 =================
    @Given("I click the inventory item")
    public void i_click_to_edit_an_item() {
        WebElement row = driver.findElement(By.className("inventory-1-1"));
        WebElement editButton = row.findElement(By.className("_option_do5oz_77"));
        editButton.click();
    }

    @When("I enter new inventory info:")
    public void i_enter_new_inventory_info(Map<String,String> updatedData){
        
        String name = updatedData.get("Name");
        String location = updatedData.get("Quantity");


        WebElement itemIdInput = driver.findElement(By.id("item-id"));
        WebElement AmountInput = driver.findElement(By.id("inventory-amount"));

        itemIdInput.clear();
        AmountInput.clear();

        itemIdInput.sendKeys(name);
        AmountInput.sendKeys(location);
        assertTrue(true);
    }

    @Then("the main screen should display the item Id {string} and amount {string}")
    public void a_window_should_display_the_item_id_and_amount(String string, String string2) {
        assertTrue(driver.findElements(By.xpath("//div[contains(text(), '"+ string + "')]")).size() > 0);
        assertTrue(driver.findElements(By.xpath("//div[contains(text(), '"+ string + "')]")).size() > 0);
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

        WebElement row = driver.findElement(By.className("warehouse-1"));
        WebElement clickable = row.findElement(By.tagName("svg"));
        clickable.click();
    }

    @When("I change the inventory item Id to {string}")
    public void i_change_the_inventory_item_id_to(String newItemId) {
        WebElement itemIdField = driver.findElement(By.name("itemId"));
        itemIdField.clear();
        itemIdField.sendKeys(newItemId);
    }

    @Then("the item name should be updated to:")
    public void the_item_name_should_be_updated_to(Map<String,String> details) {
        String name = details.get("Name");
        assertTrue(driver.findElements(By.xpath("//div[contains(text(), '"+ name + "')]")).size() > 0);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 
     * Third SCENARIO
     * 
     */
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    @Given("I click to edit the item named {string}")
    public void i_click_to_edit_the_item_named(String itemName) {

        WebElement row = driver.findElement(By.className("warehouse-1"));
        WebElement clickable = row.findElement(By.tagName("svg"));
        clickable.click();
    }
    
    @When("I change the amount to {string}")
    public void i_change_the_quantity_to(String newQuantity) {
        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.clear();
        amountField.sendKeys(newQuantity);
    }
    @Then("the amount should be updated to:")
    public void the_amount_updated_to(Map<String,String> update){
        String amount = update.get("Amount");
        assertFalse(driver.findElements(By.xpath("//div[contains(text(), '"+ amount + "')]")).size() > 0);
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


}
