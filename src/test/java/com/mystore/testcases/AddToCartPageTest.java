package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartPageTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class,groups ={ "Sanity","Regression"})
    public void addToCartTest(String product, String quantity, String size) {
        indexPage = new IndexPage();
        searchResultPage=indexPage.searchProduct(product);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(quantity);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();

        boolean result = addToCartPage.validateAddToCart();
        Assert.assertTrue(result);

    }
}
