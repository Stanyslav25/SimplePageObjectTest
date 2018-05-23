package com.pack.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends PageMethods{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    @FindBy (xpath = "//input[@name='btnK' and @type='submit']")
    private WebElement googleSearchButton;

    public SearchResultsPage enterValue(){
        if(searchField.isEnabled())
        System.out.println("Test begin...");
        waitForClickable(searchField);
        searchField.sendKeys("Asus eee PC1005p");
        googleSearchButton.click();
        return new SearchResultsPage(driver);
    }



}
