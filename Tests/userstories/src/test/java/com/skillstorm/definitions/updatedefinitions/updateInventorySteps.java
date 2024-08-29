package com.skillstorm.definitions.updatedefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class updateInventorySteps {
    
    WebDriver driver;
    WebDriverWait wait;
    WebElement clicktoEdit;

    public updateInventorySteps() {
        // Initialize WebDriver instance
        FirefoxOptions options = new FirefoxOptions();

        Duration duration = Duration.of(3, ChronoUnit.SECONDS);
	    options.setImplicitWaitTimeout(duration);

        options.addArguments("-headless");
        
        //options.addArguments("-headless");
        this.driver = new FirefoxDriver(options);
    }

    @Given("I am on {string} page")
    public void i_am_on_the_warehouses_page(String string) {
        driver.get("http://localhost:5173/warehouses"); 
        WebElement titleParent = driver.findElement(By.className("_container_1avss_1"));
        WebElement title = titleParent.findElement(By.className("_title_1avss_15"));
        assertEquals(title.getText(),string);
    }

    @And("I have existing warehouse with the following details:")
    public void i_expand_a_warehouse_s_details(List<Map<String,String>> detailsTable) {
        Map<String, String> woodshopData = new HashMap<>();

        // Find and store data related to "Woodshop"
        for (Map<String, String> map : detailsTable) {
            String name = map.get("Name");
            if ("Woodshop".equals(name)) {
                woodshopData.putAll(map);
                break; // Assuming there's only one Woodshop entry
            }
        }

        clicktoEdit = driver.findElement(By.xpath("//div[text()='" + woodshopData.get("Name") + 
        "']/ancestor::div[contains(@class, '_record_9ratk_1')]//div[contains(@class, '_edit_9ratk_71')]"));
    }

    @When("I click to edit item:")
    public void i_click_to_edit_an_item(List<Map<String,String>> details) {
        clicktoEdit.click();
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
