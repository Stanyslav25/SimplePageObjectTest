package com.pack.common.pageobjects;

import com.pack.common.tests.BasePageTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePage extends PageMethods {

    //private WebDriver driver;
    //private PageMethods pageMethods;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id=':2o']")
    private WebElement primaryMailTab;

    @FindBy(xpath="//div[@id=':2p']")
    private WebElement sosialMailTab;

    @FindBy(xpath ="//div[@id=':2q']")
    private WebElement promotionsMailTab;

    @FindBy(xpath = "//div[@class='J-J5-Ji J-JN-M-I-Jm']/span")
    private WebElement selectAllCheckbox;

    @FindBy(xpath ="//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement deleteDynamicElement;

    @FindBy(xpath = "//div[@aria-label='Delete' and @data-tooltip='Delete']")
    private WebElement deleteButton;

    @FindBy (xpath = "//span[@class='ait']/div[@class='G-asx T-I-J3 J-J5-Ji']")
    private WebElement openListbox;

    @FindBy(xpath = "//div[@id=':25']//div[@class='aRv']")
    private WebElement expectedMassage;

    @FindBy(xpath = "//table[@id=':2v']")
    private WebElement mailTable;

    @FindBy(xpath = "//table[@id=':2v']//tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//input[@id='gs_taif50']")
    private WebElement searchField;

    @FindBy(xpath="//tr//div[@class='yW']//span[@class='zF' or @class='yP']")
    private List<WebElement> massagesNames;

    @FindBy(xpath = "//tr//div[@class='T-Jo-auh']")
    private WebElement nameCheckBox;

    @FindBy(xpath = "//div[@class='gb_Ib']")
    private WebElement userProfile;

    @FindBy(xpath = "//span[@class='gb_db gbii']")
    private WebElement userProfileButton;

    @FindBy(xpath = "//div[@id=':hc']//a[@class='J-Ke n0']")
    private WebElement inbox;


    public String getTitle(){
        String inboxText = inbox.getText();
        return inboxText;
    }

    public boolean verifyMailPage(){
        String expectedText = "Inbox";
        return getTitle().contains(expectedText);
    }

    public BasePage chooseTabPromotions(){
        chooseTab(promotionsMailTab);
        return new BasePage(driver);
    }

    public BasePage chooseTabSosial(){
        chooseTab(sosialMailTab);
        return new BasePage(driver);
    }

    public void deleteAll() {
        try{
            waitForDisplay(selectAllCheckbox);
            selectAllCheckbox.click();
            if (deleteDynamicElement.isDisplayed())
            {
                while (deleteDynamicElement.isDisplayed())
                {
                    waitForDisplay(selectAllCheckbox);
                    if (deleteDynamicElement.isDisplayed()) {
                        deleteButton.click();
                        System.out.println("Page deleted");
                    } else {
                        selectAllCheckbox.click();
                        deleteButton.click();
                        selectAllCheckbox.click();
                        System.out.println("One more click");
                    }
                    System.out.println("Test done. " + expectedMassage.getText());
                }
            }else{System.out.println("There is no any massage. ");
            }
        }
        catch(Exception e){
            System.out.println("Something wrong " + e.getStackTrace());
        }
    }

     public void selectiveDeletion(){

     int mycounter=0;

     for(WebElement nameBox : massagesNames){
         mycounter++;

     if(nameBox.getText().equals("Dropbox")||nameBox.getText().equals("Dropbox Paper"))
            {
     System.out.println("Удалено письмо от:" + nameBox.getText());
     WebElement elementNameBox = nameBox.findElement(By.xpath("//tr["+ mycounter +"]//div[@class='T-Jo-auh']"));
     elementNameBox.click();
     if(deleteDynamicElement.isDisplayed())
     deleteButton.click();
            }
        }
     }

    /**public String getMyMail(){
     String myMail;

     userProfileButton.click();
     waitForDisplay(userProfile);
     myMail = userProfile.getText();
     System.out.println(myMail);
     return myMail;

     }

     public void mailValidate(){
     try {
     Assert.assertEquals("stanyslaw25@gmail.com", getMyMail());
     }
     catch (Exception e){
     System.out.println("Mail does not match");
     }
     }*/


}
