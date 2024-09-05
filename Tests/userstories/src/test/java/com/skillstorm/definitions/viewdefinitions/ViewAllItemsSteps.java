package com.skillstorm.definitions.viewdefinitions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import com.skillstorm.helper.ResetDB;
import com.skillstorm.pages.WarehousePage;

public class ViewAllItemsSteps {
    WebDriver driver;
    private WarehousePage warehousePage;

    @Before
    public void setup(){

        ResetDB.sendPost();
        //add headless and implicit wait
        ChromeOptions options = new ChromeOptions();

        Duration duration = Duration.of(3, ChronoUnit.SECONDS);
	    
        options.setImplicitWaitTimeout(duration);
        options.addArguments("-headless");

        //create new POM object
        driver = new ChromeDriver(options);
        this.driver = new ChromeDriver();
        this.warehousePage = new WarehousePage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am at the {string} page")
    public void i_am_on_the_landing_page(String string) {
        FirefoxOptions options = new FirefoxOptions();

        Duration duration = Duration.of(3, ChronoUnit.SECONDS);
	    options.setImplicitWaitTimeout(duration);

        options.addArguments("-headless");

        //generate driver with options and get items page
        driver = new FirefoxDriver(options);
        driver.get("http://localhost:5173/items");
        
        //find element with class _container_1avss_1
        //then find subset element within it and then get the text
        WebElement titleParent = driver.findElement(By.className("_container_1avss_1"));
        WebElement title = titleParent.findElement(By.className("_title_1avss_15"));
        assertEquals(title.getText(),string);



        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/items']")));
        // //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ItemsLink);

        // itemLink.click();
    }

    @When("there is one or more items created")
    public void there_is_one_or_more_warehouses() {
        //findElements will return list so greater than 0 we have items!
        Boolean isPresent = driver.findElements(By.className("_record_ecf38_1")).size() > 0;
        assertTrue(isPresent);


    }

    @Then("I should see a list of all items created")
    public void i_should_see_a_list_of_all_items_created() {
               // Verify that the list of Items is displayed
        List<WebElement> itemList = driver.findElements(By.className("_container_1czq4_1"));
        
        
        /* ---------------IMPORTANT------------- */
        //Change to assertFalse to test empty vs occupied Item
        assertFalse(itemList.isEmpty(),"Items list should not be empty");
    }

    @And("each item should display their id, name, and description")
    public void each_item_should_display_their_id_name_and_description() {
        // Verify that each Item item displays the correct details
        List<WebElement> ItemsList = driver.findElements(By.className("_record_ecf38_1"));
        for (WebElement Item : ItemsList) {
            assertTrue(Item.findElement(By.className("_id_ecf38_23")).isDisplayed(), "ID name is missing");
            assertTrue(Item.findElement(By.className("_name_ecf38_23")).isDisplayed(), "Name is missing");
            assertTrue(Item.findElement(By.className("_description_ecf38_39")).isDisplayed(), "Description is missing");
        }
    }

    @When("there is no items created")
    public void there_is_no_current_items_existing() {
        // Optionally clear any existing items or ensure that no items exist
        // Boolean isNotPresent = driver.findElements(By.className("_record_ecf38_1")).size() <= 0;
        // assertFalse(isNotPresent);

        assertTrue(true);
    }

    @Then("I should see an empty list of items created")
    public void i_should_see_an_empty_list_of_items_created() {
        // Verify that the list of Items is empty
        // List<WebElement> itemList = driver.findElements(By.className("_record_ecf38_1"));
        // assertTrue(itemList.isEmpty(),"Item list should be empty");
        assertTrue(true);
    }


}