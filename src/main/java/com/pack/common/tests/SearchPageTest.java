package com.pack.common.tests;

import com.pack.common.Base.TestBaseSetup;
import com.pack.common.pageobjects.SearchPage;
import com.pack.common.pageobjects.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchPageTest extends TestBaseSetup {

    private WebDriver driver;
    public SearchPage searchPage;
    public SearchResultsPage searchResultsPage;

    @BeforeClass
    public void setUP(){
        driver=getDriver();
    }

    @Test
    //@Parameters("appURL")
    public void searchSomeResult(){
        searchResultsPage = new SearchResultsPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.enterValue();


    }
    //class="iUh30"
}
