package com.skillstorm.definitions.navigatedefinitions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.pages.ItemsPage;
import com.skillstorm.pages.WarehousePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateSteps {
    WebDriver driver;
    WarehousePage warehousePage;
    ItemsPage itemsPage;

    @Before
    public void setup() {
        // Initialize WebDriver instance
        ChromeOptions options = new ChromeOptions();

        options.setImplicitWaitTimeout(Duration.of(3, ChronoUnit.SECONDS));
        options.addArguments("-headless");
        
        //options.addArguments("-headless");
        this.driver = new ChromeDriver(options);
        this.warehousePage = new WarehousePage( this.driver);
        this.itemsPage = new ItemsPage( this.driver);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the {string} page")
    public void i_am_on_page(String page){
        if(page.equals("Warehouses")){
            warehousePage.getMain();
            warehousePage.travelWarehouse();

        }

        else if(page.equals("Items")){
            itemsPage.getMain();
            itemsPage.travelItems();
        }
    }

    @When("I click {string} in the side bar")
    public void i_click_on_page(String page){
        warehousePage.travelWarehouse();
        itemsPage.travelItems();
    }
    @Then("I should be redirected to {string}")
    public void i_redirect_on_page(String Page){
        if(Page.equals("Warehouses")){
            itemsPage.travelWarehouse();
            warehousePage.travelWarehouse();

        }

        else if(Page.equals("Items")){
            warehousePage.getMain();
            itemsPage.travelItems();
        }
    }
}
