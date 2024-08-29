package com.skillstorm.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.Selenium.WarehousePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteWarehouseSteps {
    

private WebDriver driver;
private WarehousePage warehousePage;

@Before("deletewarehouse")
public void before(){
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    this.driver = new ChromeDriver();
    this.warehousePage = new WarehousePage(driver);
}

@After("@deleteWarehouse")
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
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@When("the user clicks the delete button")
public void the_user_clicks_the_delete_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("the warehouse should be removed")
public void the_warehouse_should_be_removed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("the inventory with the warehouse id should be removed")
public void the_inventory_with_the_warehouse_id_should_be_removed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}


}
