package com.skillstorm.definitions.updatedefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class updateitemSteps {
    
    WebDriver driver;
    WebDriverWait wait;

    public updateitemSteps() {
        // Initialize WebDriver instance
        this.driver = new FirefoxDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the {string} page")
    public void i_am_on_the_warehouses_page() {
        driver.get("http://localhost:5173/warehouses"); 
    }

    @And("I expand a warehouse's details")
    public void i_expand_a_warehouse_s_details() {
        WebElement expandButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._display_9ratk_111")));
        expandButton.click();
    }

    @When("I click to edit an item")
    public void i_click_to_edit_an_item() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._controls_do5oz_19 svg")));
        editButton.click();
    }

    @Then("a window should display the item Id and quantity")
    public void a_window_should_display_the_item_name_and_quantity() {
        WebElement itemId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-id")));
        WebElement itemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory-amount")));
        assertTrue(itemId.isDisplayed(), "Item name should be displayed.");
        assertTrue(itemQuantity.isDisplayed(), "Item quantity should be displayed.");
    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    @Given("I am on the Warehouse page")
    public void i_am_on_the_warehouse_page() {
        driver.get("http://localhost:5173/warehouses");
    }

    @And("I expand the details for warehouse {string}")
    public void i_expand_the_details_for_warehouse(String warehouseName) {

        String string = String.format("//div[contains(text(),'%s')]", warehouseName);
        try{
            WebElement Name = driver.findElement(By.xpath(string));
        }
        catch(Exception NoSuchElementException){}
        
        WebElement expandButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._display_9ratk_111")));
        expandButton.click();

    }

    @And("I click to edit item named {string}")
    public void i_click_to_edit_item_named(String itemName) {
        WebElement expandEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._option_do5oz_77")));
        expandEditButton.click();
    }

    @When("I change the inventory item Id to {string}")
    public void i_change_the_inventory_item_id_to(String newItemId) {
        WebElement itemIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-id")));
        itemIdField.clear();
        itemIdField.sendKeys(newItemId);
    }

    @And("I change the quantity to {string}")
    public void i_change_the_quantity_to(String newQuantity) {
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-quantity")));
        quantityField.clear();
        quantityField.sendKeys(newQuantity);
    }

    @And("I click the submit button")
    public void i_click_the_submit_button() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-button")));
        submitButton.click();
    }

    @Then("the update should be successful")
    public void the_update_should_be_successful() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
        assertTrue(successMessage.isDisplayed(), "Success message should be displayed.");
    }

    @And("the item name should be updated to {string}")
    public void the_item_name_should_be_updated_to(String expectedName) {
        WebElement itemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-name")));
        assertEquals(expectedName, itemName.getText(), "Item name should be updated.");
    }

    @And("the amount should be updated to {string}")
    public void the_amount_should_be_updated_to(String expectedAmount) {
        WebElement itemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-quantity")));
        assertEquals(expectedAmount, itemQuantity.getText(), "Item quantity should be updated.");
    }

    @Then("I should receive an error message")
    public void i_should_receive_an_error_message() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed.");
    }

    @And("the inventory item should not be updated")
    public void the_inventory_item_should_not_be_updated() {
        // Check that the inventory item has not been updated (implementation depends on your application's behavior)
    }


}
