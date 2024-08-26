package com.skillstorm.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.en.And;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class ViewAllItemsSteps {
    WebDriver itemDriver;

    @Given("I am at the landing page")
    public void i_am_on_the_landing_page() {
        FirefoxOptions options = new FirefoxOptions();

        itemDriver = new FirefoxDriver(options);
        itemDriver.get("http://localhost:5173");
    }

    @When("I navigate to the items page")
    public void i_navigate_to_the_items_page() {
        // Navigate by anchro linktext

        WebDriverWait wait = new WebDriverWait(itemDriver, Duration.ofSeconds(5));
        WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/items']")));
        //((JavascriptExecutor) itemDriver).executeScript("arguments[0].scrollIntoView(true);", ItemsLink);

        itemLink.click();
    }

    @Then("I should see a list of all items created")
    public void i_should_see_a_list_of_all_items_created() {
               // Verify that the list of Items is displayed
        List<WebElement> itemList = itemDriver.findElements(By.className("_container_1czq4_1"));
        
        
        /* ---------------IMPORTANT------------- */
        //Change to assertFalse to test empty vs occupied Item
        assertFalse(itemList.isEmpty(),"Items list should not be empty");
    }

    @And("each item should display their id, name, and description")
    public void each_item_should_display_their_id_name_and_description() {
        // Verify that each Item item displays the correct details
        List<WebElement> ItemsList = itemDriver.findElements(By.className("_record_ecf38_1"));
        for (WebElement Item : ItemsList) {
            assertTrue(Item.findElement(By.className("_id_ecf38_23")).isDisplayed(), "ID name is missing");
            assertTrue(Item.findElement(By.className("_name_ecf38_23")).isDisplayed(), "Name is missing");
            assertTrue(Item.findElement(By.className("_description_ecf38_39")).isDisplayed(), "Description is missing");
        }
    }

    @When("there is no current items existing")
    public void there_is_no_current_items_existing() {
        // Optionally clear any existing items or ensure that no items exist
    }

    @Then("I should see an empty list of items created")
    public void i_should_see_an_empty_list_of_items_created() {
        // Verify that the list of Items is empty
        List<WebElement> itemList = itemDriver.findElements(By.className("_record_ecf38_1"));
        assertFalse(itemList.isEmpty(),"Item list should be empty");
    }

        @After
    public void tearDown() {
        if (itemDriver != null) {
            itemDriver.quit();
        }
    }
}