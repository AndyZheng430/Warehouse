package com.skillstorm.definitions.adddefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.skillstorm.pages.WarehousePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddInventorySteps {
    
    private WebDriver driver;
    private WarehousePage warehousePage;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-headless");
        driver = new ChromeDriver(options);
        warehousePage = new WarehousePage(driver);
    }
    
    @After
    public void after () {
        if(driver != null) {
            driver.quit();
        }
    }

    @Given("I am currently on the warehouse page")
    public void onTheWarehousePage() {
        warehousePage.getMain();
        warehousePage.travelWarehouse();
    }

    @When("When I click on the Add button")
    public void whenTheIClickOnTheAddButton() {
        WebElement warehouseRow = driver.findElement(By.xpath("//div[contains(@class, 'warehouse-1')]"));
        WebElement addButton = warehouseRow.findElement(By.className("_add_2cuiw_26"));
        addButton.click();
    }

    @And("enters an inventory item id")
    public void enterItemId() {
        warehousePage.setItemId("1");
    }

    @And("enters an inventory amount")
    public void enterAmount() {
        warehousePage.setInventoryAmount("10");
    }

    @And("enters an inventory amount greater than the warehouse capacity")
    public void enterAmountGreaterThanCapacity() {
        warehousePage.setInventoryAmount("10000");
    }
    
    @And("clicks the inventory submit button")
    public void clicksTheSubmitButton() {
        warehousePage.clickSubmit();
    }
    
    @Then("create new inventory with the warehouse, item, and amount")
    public void createNewInventory(){
        Boolean isPresent = driver.findElements(By.className("inventory-1-1")).size() > 0;
        assertTrue(isPresent);
    }

    @Then("a new inventory should not be created")
    public void inventoryNotCreated() {
        Boolean isPresent = driver.findElements(By.className("inventory-1-1")).size() > 0;
        assertFalse(isPresent);
    }
}
