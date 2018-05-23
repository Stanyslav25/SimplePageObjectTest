package com.pack.common.tests;

import com.pack.common.Base.TestBaseSetup;
import com.pack.common.pageobjects.BasePage;
import com.pack.common.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasePageTests extends TestBaseSetup {

    public WebDriver driver;
    public SignInPage signInPage;
    public BasePage basePage;

    @BeforeClass
    public void setUp()
    {
        driver = getDriver();
    }

    @Test
    public void PageTest() {

        signInPage = new SignInPage(driver);
        basePage = new BasePage(driver);
        signInPage.inputIntoMail();
        basePage.verifyMailPage();
        basePage.chooseTabPromotions();
        basePage.deleteAll();

    }

}
