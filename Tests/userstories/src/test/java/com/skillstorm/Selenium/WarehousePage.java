package com.skillstorm.Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WarehousePage {
    


     private WebDriver driver;
    private static final String url = "http://team8-frontend.s3-website-us-east-1.amazonaws.com/";

    @FindBy(linkText = "warehouses")
    private WebElement warehousesLink;


    public WarehousePage(WebDriver driver) {
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

    public void travelWarehouse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehousesLink.click();
    }

}
