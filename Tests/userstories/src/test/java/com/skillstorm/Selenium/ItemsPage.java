package com.skillstorm.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//common webelemts and methods for the item page implementing the page object model
public class ItemsPage {

    //class fields
    private WebDriver driver;
    private static final String url = "http://team8-frontend.s3-website-us-east-1.amazonaws.com/";


    //Creating webelements for elements on the Items page that I will need to access.

    @FindBy(xpath = "//a[@href='/items']")
    private WebElement itemLink;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createButton;

    @FindBy(id = "item-name")
    private WebElement itemNameField;

    @FindBy(id = "item-description")
    private WebElement itemDescriptionField;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    // constructor for an itempage object
     public ItemsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    // this method navigates to the main page of our application
    public void getMain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.get(url);
    }

    //this method travels from the main page to the items page
    public void travelItems() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemLink.click();
    }
    // this item will click the create button that opens the model to add an item
    public void clickCreate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createButton.click();
    }

    //this method will inter a item name into the item name field when creating a new item
    public void setItemName(String itemName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemNameField.sendKeys(itemName);
    }


    //this method will add a description to the item description field when creating a new item
    public void setItemDescription(String itemDescription) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemDescriptionField.sendKeys(itemDescription);
    }


    // this method will click the submit button to submit the add an item form
    public void clickSubmit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
    }




}
