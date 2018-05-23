package com.pack.common.tests;

import com.pack.common.Base.TestBaseSetup;
import com.pack.common.pageobjects.BasePage;
import com.pack.common.pageobjects.SignInPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInPageTest extends TestBaseSetup {

    public WebDriver driver;
    public SignInPage signInPage;
    public BasePage basePage;

    @BeforeClass

    public void setUp(){
        driver = getDriver();
               }

    @Test
    public void verifyBasePage(){

        signInPage = new SignInPage(driver);
        basePage = new BasePage(driver);
        System.out.println("Signin page test...");
        signInPage.inputIntoMail();
        basePage.verifyMailPage();
    }

//вынести драйвер в отдельный класс чтобы от него наследовались остальные классы
//Выделить работу с филдами в отдельный метод (принимаем Web element передаем Value)
//Сделать return mail page
//переделать валидацию, прикрепится к элементу на который должен быть на данной странице и он был visible
//вынести валидацию в отдельный метод, при каждом переходе на новую страницу проверка


}
