package com.skillstorm.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ItemsPage {
    private WebDriver driver;
    private static final String url = "http://team8-frontend.s3-website-us-east-1.amazonaws.com/";

    @FindBy(linkText = "items")
    private WebElement itemLink;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(id = "item-name")
    private WebElement itemNameField;

    @FindBy(id = "item-name")
    private WebElement itemDescriptionField;

    @FindBy(xpath = "//button[text()='submit']")
    private WebElement submitButton;


     public ItemsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void getMain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.get(url);
    }

    public void travelItems() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemLink.click();
    }

    public void clickCreate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createButton.click();
    }

    public void setItemName(String itemName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemNameField.sendKeys(itemName);
    }


    public void setItemDescription(String itemDescription) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemDescriptionField.sendKeys(itemDescription);
    }


    public void clickSubmit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
    }




}
