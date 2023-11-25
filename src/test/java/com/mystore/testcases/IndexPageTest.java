package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }

    IndexPage indexPage;

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void verifyLogo() {
        indexPage =  new IndexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
    }


    @Test(groups = "Smoke")
    public void verifyTitle() {
        String actTitle = indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle,"My Shop");
    }


}
