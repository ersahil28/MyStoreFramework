package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    OrderSummary orderSummary;
    OrderConfirmationPage orderConfirmationPage;

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    @Parameters("browser")
    public void setup(String browser) {
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        // driver.quit();
    }

    @Test(dataProvider = "getProduct",dataProviderClass = DataProviders.class, groups = "Regression")
    public void endToEndTest(String product, String quantity, String size) {
        indexPage = new IndexPage();
        searchResultPage=indexPage.searchProduct(product);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(quantity);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckout();
        loginPage=orderPage.clickOnCheckout();
        addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage=addressPage.clickOnCheckout();
        shippingPage.checkTheTerms();
        paymentPage=shippingPage.clickOnProceedToCheckout();
        orderSummary=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummary.clickOnConfirmButton();
        String actualMessage = orderConfirmationPage.validateConfirmMessage();
        String expecteMessage = "Your order on My Shop is complete.";
        Assert.assertEquals(actualMessage,expecteMessage);




    }

}
