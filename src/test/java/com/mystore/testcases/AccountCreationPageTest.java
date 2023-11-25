package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

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

    @Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
    public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
        Log.startTestCase("createAccountTest");
        indexPage= new IndexPage();
        loginPage=indexPage.clickOnSignIn();
        accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
        accountCreationPage.createAccount(
                hashMapValue.get("Gender"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("SetPassword"),
                hashMapValue.get("Day"),
                hashMapValue.get("Month"),
                hashMapValue.get("Year"),
                hashMapValue.get("Company"),
                hashMapValue.get("Address"),
                hashMapValue.get("City"),
                hashMapValue.get("State"),
                hashMapValue.get("Zipcode"),
                hashMapValue.get("Country"),
                hashMapValue.get("MobilePhone"));
        homePage=accountCreationPage.validateRegistration();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrentUrl());
        Log.endTestCase("createAccountTest");
    }


}
