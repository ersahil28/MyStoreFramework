package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    SearchResultPage searchResultPage;

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void productAvailabilityTest() {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
    }


}
