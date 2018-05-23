package com.pack.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageMethods {

    //private WebDriver driver;
    //private PageMethods pageMethods;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "identifierId")
    public WebElement loginField;

    @FindBy(xpath = "//[@id='identifierNext']")
    public WebElement buttonNext;

    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(id = "passwordNext")
    public WebElement passwordButtonNext;

   public BasePage inputIntoMail(){
        enterUserName();
        enterPassword();
        return new BasePage(driver);
    }

    public SignInPage enterUserName(){
           if(loginField.isDisplayed())
           clearAndSendKey(loginField, "stanyslaw25");
           buttonNext.click();
           return new SignInPage(driver);
    }

    public void enterPassword(){
        if(passwordField.isDisplayed())
            clearAndSendKey(passwordButtonNext, "555");
            passwordButtonNext.click();
    }

}


