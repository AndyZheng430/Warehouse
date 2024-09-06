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

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import com.skillstorm.helper.ResetDB;
import com.skillstorm.pages.ItemsPage;
import com.skillstorm.pages.WarehousePage;

public class ViewAllItemsSteps {
    WebDriver driver;
    private ItemsPage itemsPage;

    @Before
    public void setup(){

        ResetDB.sendPost();
        //add headless and implicit wait
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.of(3, ChronoUnit.SECONDS));
        options.addArguments("-headless");

        //create new POM object
        this.driver = new ChromeDriver(options);
        this.itemsPage = new ItemsPage(this.driver);
    }

    @After
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Given("I am at the {string} page")
    public void i_am_on_the_items_page(String string) {

        //find element with class _container_1avss_1
        //then find subset element within it and then get the text
        this.itemsPage.getMain();
        
        assertEquals(this.itemsPage.getTitle(),string);



        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // WebElement itemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/items']")));
        // //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ItemsLink);

        // itemLink.click();
    }

    @When("there is one or more items created")
    public void there_is_one_or_more_items() {
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

}