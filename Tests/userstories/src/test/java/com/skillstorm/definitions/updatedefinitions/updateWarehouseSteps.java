package com.skillstorm.definitions.updatedefinitions;

import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UpdateWarehouseSteps {
    WebDriver driver;

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String string) {
        FirefoxOptions options = new FirefoxOptions();

        Duration duration = Duration.of(3, ChronoUnit.SECONDS);
	    options.setImplicitWaitTimeout(duration);

        options.addArguments("-headless");

        //generate driver with options and get items page
        driver = new FirefoxDriver(options);
        driver.get("http://localhost:5173/warehouses");

        WebElement titleParent = driver.findElement(By.className("_container_1avss_1"));
        WebElement title = titleParent.findElement(By.className("_title_1avss_15"));
        assertEquals(title.getText(),string);
    }

    @Given("I have an existing warehouse with the following details:")
    public void i_have_an_existing_warehouse_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {

    }
    @When("I edit the warehouse named {string}")
    public void i_edit_the_warehouse_named(String string) {

    }
    @When("I update the details :")
    public void i_update_the_details(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("I should see the updated warehouse details in the table")
    public void i_should_see_the_updated_warehouse_details_in_the_table() {

    }

    @When("I click the edit symbol for the warehouse named {string}")
    public void i_click_the_edit_symbol_for_the_warehouse_named(String string) {

    }
    @When("I update the value to a negative value of {string}")
    public void i_update_the_value_to_a_negative_value_of(String string) {

    }
    @Then("the warehouse details should remain unchanged in the table")
    public void the_warehouse_details_should_remain_unchanged_in_the_table() {

    }
}
