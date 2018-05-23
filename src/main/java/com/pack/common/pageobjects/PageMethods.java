package com.pack.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageMethods {

    public PageMethods (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;


    public void waitForClickable (WebElement myElement) {
        WebDriverWait waiting = new WebDriverWait(driver, 15);
        waiting.until(ExpectedConditions.elementToBeClickable(myElement));
    }

    public void waitForDisplay(WebElement myElement){
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.visibilityOf(myElement));
    }

    public BasePage chooseTab(WebElement myTab){
        waitForClickable(myTab);
        myTab.click();
        return new BasePage(driver);
    }

    public void clearAndSendKey(WebElement myElement, String keyValue) {
        myElement.clear();
        myElement.sendKeys(keyValue);
    }


}
