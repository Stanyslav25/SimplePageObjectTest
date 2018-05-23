package com.pack.common.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public  class TestBaseSetup {

    public WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(String appURL){
        driver = initFirefoxDriver(appURL);
    }

    public static WebDriver initFirefoxDriver(String appURL){

        System.out.println("Launching Firefox browser....");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appURL);
        return driver;
    }

    @Parameters("appURL")
    @BeforeClass

    public void initializeTestBaseSetup(String appURL){
        try{
            setDriver(appURL);
        } catch (Exception e){
            System.out.println("Error " + e.getStackTrace());
        }
    }

   @AfterClass
    public void tearDown(){
        if(driver!=null)
        driver.quit();
    }

}
