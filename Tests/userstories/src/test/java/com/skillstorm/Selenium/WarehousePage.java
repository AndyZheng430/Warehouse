package com.skillstorm.Selenium;

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


    //delete button for delete warehouse button needed for delete warehouse test
    @FindBy(xpath ="//*[@id=\"root\"]/main/div/div[6]/div[8]")
    private WebElement deleteButton;

    //name field for warehouse used to validate deletion
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[6]/div[2]")
    private WebElement warehouseName;

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

}
