package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

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

    @Test(dataProvider = "credentials",dataProviderClass = DataProviders.class, groups = {"Smoke","Smoke"})
    public void loginTest(String uname, String upswd) {
        Log.startTestCase("loginTest");
        indexPage =  new IndexPage();
        Log.info("User is going to click on SignIn");
        loginPage = indexPage.clickOnSignIn();
        Log.info("Enter Username and Password");
        //homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
        homePage = loginPage.login(uname,upswd);
        String actualUrl = homePage.getCurrentUrl();
        String expectedUrl = "http://www.automationpractice.pl/index.php?controller=my-account" ;
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualUrl,expectedUrl);
        Log.endTestCase("loginTest");
    }


}
