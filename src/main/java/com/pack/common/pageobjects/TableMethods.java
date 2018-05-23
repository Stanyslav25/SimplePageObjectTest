package com.pack.common.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class TableMethods {

    private WebElement tableElement;
    private WebDriver driver;

    public TableMethods (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getElements(WebElement myElement){

        List<WebElement> rows = tableElement.findElements((By)(myElement));
        System.out.println(myElement.getText());
        return rows;
    }

}
