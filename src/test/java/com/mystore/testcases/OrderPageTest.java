package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
       // driver.quit();
    }

    @Test(groups = "Regression")
    public void verifyTotalPrice() {
        indexPage = new IndexPage();
        searchResultPage=indexPage.searchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectSize("M");
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckout();
        Double unitPrice =orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totalExpectedPrice = (unitPrice*2)+7;
        Assert.assertEquals(totalPrice,totalExpectedPrice);

    }

}
