package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationPageTest extends BaseClass {

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(dataProvider = "email",dataProviderClass = DataProviders.class,groups = "Sanity")
    public void verifyCreateAccountPageTest(String email) {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount(email);
        boolean result = accountCreationPage.validateAccountCreatePage();
        Assert.assertTrue(result);
    }

}
