package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void orderHistoryAndDetailsTest() {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
    }




}
