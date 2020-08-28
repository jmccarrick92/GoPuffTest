package com.goPuff_Search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoPuffElements {
    //Web Elements
    static By orderNowBtn = By.xpath("//*[@id=\"hero-carousel\"]/div/div[2]/div/div[2]/div[3]/a/button");
    static By confirmAddressBtn = By.id("mapAddAdddress");
    static By productSearchBar = By.xpath("//*[@id=\"product-search\"]");
    static By zipCodeOkBtn = By.xpath("//*[@id=\"1\"]");



    //Methods
    public void clickOrderNow(WebDriver driver) {
        driver.findElement(orderNowBtn).click();
    }

    public void clickConfirmAddress(WebDriver driver) {
        try {
            driver.findElement(confirmAddressBtn).click();
        } catch(Exception e){
            driver.findElement(zipCodeOkBtn).click();
            driver.findElement(confirmAddressBtn).click();
        }
    }

    public void searchForProduct(WebDriver driver, String product) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSearchBar));
        driver.findElement(productSearchBar).click();
        driver.findElement(productSearchBar).sendKeys(product);
        actions.sendKeys(Keys.ENTER);
    }

}
