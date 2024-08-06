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

import com.skillstorm.helper.ResetDB;
import com.skillstorm.pages.ItemsPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

public class UpdateItemSteps {
    
    WebDriver driver;
    private ItemsPage itemsPage;

    //typical Beforfe and After hooks
    //reset DB and then setup drivers!
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
    @Given("I am at the {string} page")
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
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'" + ID +"')]")).size() >0);
    }

    //find using POM helper functions
    @When("I click the edit button for the item with ID {string}")
    public void i_click_to_edit_an_item(String ID) {
        WebElement row = driver.findElement(By.className("item-"+ ID));
        WebElement editButton = row.findElement(By.tagName("svg"));
        editButton.click();

    }

    @And("I update the name to {string}")
    public void i_update_the_name_to(String name) {
        itemsPage.setItemName(name);
        
    }
    @And("I update the description to {string}")
    public void i_update_the_descr_to(String description) {
        itemsPage.setItemDescription(description);
  
    }
    //see updated details using table parameter
    @Then("I should see the updated item details:")
    public void I_should_see_updated_item_detail(Map<String,String> updatedItem) {
        //assertTrue(itemId.isDisplayed(), "Item name should be displayed.");
        //assertTrue(itemQuantity.isDisplayed(), "Item quantity should be displayed.");
        String test = updatedItem.get("Name");
        assertFalse(driver.findElements(By.xpath("//div[contains(text(),'"+ test+ "')]")).size()>0);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /*
     * SCENARIO 2
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    //same format as before
    //use xpath to simplify everything!
    @Given("I have existing item with the following details:")
    public void i_have_existing_item_with_id_and_the_following_details(Map<String, String> details) {
        String ID = details.get("Name");;
        String descr = details.get("Description");
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'"+ ID+ "')]")).size()>0);
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'"+ descr+ "')]")).size()>0);
        
    }
    @When("I click to edit the item")
    public void i_click_the_symbol_for_the_item_with_id() {
        WebElement row = driver.findElement(By.className("item-3"));
        WebElement editButton = row.findElement(By.tagName("svg"));
        editButton.click();
 
    }
    @When(" I update the name to {string}")
    public void i_update_name_as(String name){
        itemsPage.setItemName(name);
    }

    @Then("the item name should say {string}")
    public void the_item_name_should_say(String name) {
        assertFalse(driver.findElements(By.xpath("//div[contains(text(),'"+ name+ "')]")).size()>0);
    }

}
