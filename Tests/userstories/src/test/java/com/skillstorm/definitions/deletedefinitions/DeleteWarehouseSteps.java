package com.skillstorm.definitions.deletedefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.Selenium.WarehousePage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteWarehouseSteps {
    

private WebDriver driver;
private WarehousePage warehousePage;

@Before
public void before(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("-headless");
    driver = new ChromeDriver(options);
    this.driver = new ChromeDriver(options);
    this.warehousePage = new WarehousePage(driver);
}

@After
public void after(){
    if(driver != null) {
            this.driver.quit();
        }
}

@Given("the user is on the warehouse page")
public void the_user_is_on_the_warehouse_page() {
    this.warehousePage.getMain();
    this.warehousePage.travelWarehouse();
}
@Given("there is a warehouse")
public void there_is_a_warehouse() {
   Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[6]/div[2]")).size() > 0;
    assertTrue(isPresent);
}
@When("the user clicks the delete warehouse button to delete a warehouse")
public void the_user_clicks_the_delete_button() {
    warehousePage.clickDelete();
}
@Then("the warehouse should be removed")
public void the_warehouse_should_be_removed() {
    Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[6]/div[2]")).size() > 0;
    assertFalse(isPresent);
}
@Then("the inventory with the warehouse id should be removed")
public void the_inventory_with_the_warehouse_id_should_be_removed() {
    Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[8]/div[1]/div[2]/div[1]")).size() > 0;
    assertFalse(isPresent);
}


}
