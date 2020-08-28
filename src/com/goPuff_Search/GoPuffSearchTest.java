package com.goPuff_Search;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.goPuff_Search.CommonConstants.*;

public class GoPuffSearchTest {

    public static void main(String[] args) throws InterruptedException {
        GoPuffElements goPuffElements = new GoPuffElements();
        WebDriver driver = launchGoPuff();
        goPuffElements.clickOrderNow(driver);
        goPuffElements.clickConfirmAddress(driver);

        goPuffElements.searchForProduct(driver, "doritos");

        try {
            driver.getPageSource().contains("Doritos Nacho Cheese 15oz");
            System.out.println("Doritos Found");
        } catch (Exception e) {
            System.out.println("Doritos Not Found");
        }

        driver.quit();
    }

    public static WebDriver launchGoPuff() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(goPuff);
        driver.manage().window().maximize();
        return driver;
    }
}
