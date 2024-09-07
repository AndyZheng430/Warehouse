package com.skillstorm.definitions.deletedefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.pages.ItemsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DeleteItemSteps {
    private WebDriver driver;
    private ItemsPage itemsPage;
    
@Before
public void before(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("-headless");
    driver = new ChromeDriver(options);
    this.driver = new ChromeDriver(options);
    this.itemsPage = new ItemsPage(driver);
}

 @After
    public void after() {
        if(driver != null) {
            this.driver.quit();
        }
    }



    @Given("the user is on the Item page")
    public void the_user_is_on_the_item_page() {
        this.itemsPage.getMain();
        this.itemsPage.travelItems();
    }
    @Given("there is an item")
    public void there_is_an_item() {
         Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[7]/div[3]")).size() > 0;
    assertTrue(isPresent);
    }
    

    @When("the user clicks the delete item button to delete an item")
    public void the_user_clicks_the_delete_button() {
        itemsPage.clickDelete();
    }
    @Then("the item should be removed")
    public void the_item_should_be_removed() {
        Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[7]/div[3]")).size() > 0;
    assertTrue(isPresent);
    }
    @Then("all inventory with the item id should be removed")
    public void all_inventory_with_the_item_id_should_be_removed() {
        
        itemsPage.travelWarehouse();
        Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/main/div/div[8]/div[1]/div[2]/div[1]")).size() > 0;
    assertTrue(isPresent);

    }


}
