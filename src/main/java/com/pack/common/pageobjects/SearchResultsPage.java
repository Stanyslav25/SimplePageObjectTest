package com.pack.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends TableMethods {

    public WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//cite[@class='iUh30']")
    private List<WebElement> links;

    public void myResults(WebElement links){
        getElements(links);
    }

}
