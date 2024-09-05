package com.skillstorm.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//this class if for creating a warehouse page object implementing the page object model

public class WarehousePage {
    

    //class fields

    private WebDriver driver;
    private static final String url = "http://team8-frontend.s3-website-us-east-1.amazonaws.com/";


    //creating webelements from elements on the warehouse page to be interacted with later
    @FindBy(xpath = "//a[@href='/warehouses']")
    private WebElement warehousesLink;

    @FindBy(xpath = "//button[contains(text(),' Create')]")
    private WebElement createButton;

    //delete button for delete warehouse button needed for delete warehouse test
    @FindBy(xpath ="//*[@id=\"root\"]/main/div/div[6]/div[8]")
    private WebElement deleteButton;

    //name field for warehouse used to validate deletion
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[6]/div[2]")
    private WebElement warehouseName;

    // Warehouse Modal Fields
    @FindBy(id = "warehouse-name")
    public WebElement warehouseNameField;

    @FindBy(id = "warehouse-owner")
    public WebElement warehouseOwnerField;

    @FindBy(id = "warehouse-location")
    public WebElement warehouseLocationField;

    @FindBy(id = "warehouse-capacity")
    public WebElement warehouseCapacityField;

    // Inventory Modal Fields
    @FindBy(id = "item-id")
    public WebElement itemIdField;

    @FindBy(id = "inventory-amount")
    public WebElement inventoryAmountField;

    // Modal Submit Button
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    //class constructor
    public WarehousePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    //this method takes you to the main page of our application
    public void getMain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.get(url);
    }

    //this method travels to the warehouse page
    public void travelWarehouse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehousesLink.click();
    }

    //this method travels to the warehouse page
    public void clickDelete() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteButton.click();
    }

    // click on Create button 
    public void clickCreate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createButton.click();
    }

    // set warehouse name field in Warehouse Modal
    public void setWarehouseNameField(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehouseNameField.sendKeys(name);
    }

    // set warehouse owner field in Warehouse modal 
    public void setWarehouseOwner(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehouseOwnerField.sendKeys(name);
    }

    // set warehouse location field in Warehouse modal 
    public void setWarehouseLocation(String location) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehouseLocationField.sendKeys(location);
    }

    // set warehouse capacity field in Warehouse modal 
    public void setWarehouseCapacity(String amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehouseCapacityField.sendKeys(amount);
    }

    // set inventory item id field in Warehouse modal 
    public void setItemId(String id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemIdField.sendKeys(id);
    }

    // set inventory amount field in Warehouse modal
    public void setInventoryAmount(String amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inventoryAmountField.sendKeys(amount);
    }

    // click on Warehouse or Inventory modal submit button 
    public void clickSubmit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
    }
}
