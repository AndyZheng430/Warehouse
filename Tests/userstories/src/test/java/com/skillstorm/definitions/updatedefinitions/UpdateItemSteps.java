package com.skillstorm.definitions.updatedefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillstorm.helper.ResetDB;
import com.skillstorm.pages.ItemsPage;
import com.skillstorm.pages.WarehousePage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class UpdateItemSteps {
    
    WebDriver driver;
    private ItemsPage itemsPage;

    @Before
    public void setup(){

        ResetDB.sendPost();
        //add headless and implicit wait
        ChromeOptions options = new ChromeOptions();

        options.setImplicitWaitTimeout(Duration.of(3, ChronoUnit.SECONDS));
        options.addArguments("-headless");

        //create new POM object
        this.driver = new ChromeDriver(options);
        this.itemsPage = new ItemsPage(driver);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * BACKGROUND
     */
    ///////////////////////////////////////////////////////////////////////////////////////////
    @Given("I am on the {string} page")
    public void i_am_on_the_warehouses_page(String expectedTitle) {
        itemsPage.getMain();
        assertEquals(this.itemsPage.getTitle(),expectedTitle);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * SCENARIO 1
     */
    ///////////////////////////////////////////////////////////////////////////////////////////
    @Given("I have an existing item with ID {string}")
    public void i_have_existing_item(String ID) {

    }

    @When("I click to edit an inventory item")
    public void i_click_to_edit_an_item() {
        //WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._controls_do5oz_19 svg")));
        //editButton.click();
    }

    @Then("a window should display the item Id and quantity")
    public void a_window_should_display_the_item_name_and_quantity() {
        //WebElement itemId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-id")));
        //WebElement itemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory-amount")));
        //assertTrue(itemId.isDisplayed(), "Item name should be displayed.");
        //assertTrue(itemQuantity.isDisplayed(), "Item quantity should be displayed.");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * SCENARIO 2
     */
    ///////////////////////////////////////////////////////////////////////////////////////////
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
        
        //WebElement expandButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._display_9ratk_111")));
        //expandButton.click();

    }

    @And("I click to edit item named {string}")
    public void i_click_to_edit_item_named(String itemName) {
        //WebElement expandEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._option_do5oz_77")));
        //expandEditButton.click();
    }


    @And("I change the quantity to {string}")
    public void i_change_the_quantity_to(String newQuantity) {
        //WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-quantity")));
        //quantityField.clear();
        //quantityField.sendKeys(newQuantity);
    }

    @And("I click the submit button")
    public void i_click_the_submit_button() {
        //WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-button")));
        //submitButton.click();
    }

    @Then("the update should be successful")
    public void the_update_should_be_successful() {
        //WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));
        //assertTrue(successMessage.isDisplayed(), "Success message should be displayed.");
    }

    @And("the item name should be updated to {string}")
    public void the_item_name_should_be_updated_to(String expectedName) {
        //WebElement itemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-name")));
       //ssertEquals(expectedName, itemName.getText(), "Item name should be updated.");
    }

    @And("the amount should be updated to {string}")
    public void the_amount_should_be_updated_to(String expectedAmount) {
        //WebElement itemQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-quantity")));
        //assertEquals(expectedAmount, itemQuantity.getText(), "Item quantity should be updated.");
    }

    @Then("I should receive an error message")
    public void i_should_receive_an_error_message() {
        //WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message")));
        //assertTrue(errorMessage.isDisplayed(), "Error message should be displayed.");
    }

    @And("the inventory item should not be updated")
    public void the_inventory_item_should_not_be_updated() {
        // Check that the inventory item has not been updated (implementation depends on your application's behavior)
    }


}
