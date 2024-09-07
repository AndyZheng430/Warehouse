package com.skillstorm.definitions.deletedefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillstorm.pages.WarehousePage;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DeleteInventorySteps {
    
    WebDriver driver;
    WarehousePage warehousePage;
    
    //WebElement warehouseRow;
    //WebElement expandButton;


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
    
    //background
    //same setup as others
    @Given("I am on the {string} page")
    public void i_navigate_to_the_warehouses_page(String name) {
        this.warehousePage.getMain();
        assertEquals(this.warehousePage.getTitle(),name);
    }

    @And("I have expanded the warehouse named {string} to view its inventory")
    public void i_expand_the_warehouse_named(String warehouseName) {
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'" + warehouseName +"')]")).size() > 0);
    }

    /////////////////////////////////////////////////////////////////
    //scenario 1

    @Given("I have an existing inventory {string}")
    public void i_have_an_existing_inventory_item_with_item_id_in_warehouse_id(String string) {
        //findelements will return list so use that for
    assertTrue(driver.findElements(By.xpath("//div[contains(text(),'" + string +"')]")).size() >0);
    }

    @When("I click the delete button")
    public void theUserClicksTheDeleteButtonForTheWarehouse() {
        //sublocate element
        WebElement row = driver.findElement(By.className("inventory-2-1"));
        WebElement clickBut = row.findElement(By.className("_option_do5oz_77"));
        clickBut.click();
    }

    
    @Then("the inventory item should dissapear")
    public void the_inventory_item_should_not_be_listed() {
        //we opposite assert
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'Couch')]")).size() > 0);
    }

    //Scenario 2

    @Given("I have an nonexisting inventory {string}")
    public void i_have_nonexisting_inventory_item(String name) {
        assertFalse(driver.findElements(By.xpath("//div[contains(text(),'" + name +"')]")).size() >0);
    }

    @When("I try to click the associated delete button")
    public void theUserClicksdelete() {
        WebElement row = driver.findElement(By.className("warehouse-1"));
        WebElement clickBut = row.findElement(By.className("_edit_9ratk_71"));
        clickBut.click();
    }

    
    @Then("nothing should happen")
    public void _item_should_not_be_listed() {
        //application shows no new inventoru
        assertTrue(driver.findElements(By.xpath("//div[contains(text(),'screw')]")).size() == 0);
    }
}
