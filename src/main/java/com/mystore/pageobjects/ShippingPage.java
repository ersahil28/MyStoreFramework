package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement terms;


    public ShippingPage() {
        PageFactory.initElements(driver,this);
    }

    public void checkTheTerms() {
        action.click(driver,terms);
    }

    public PaymentPage clickOnProceedToCheckout() {
        action.click(driver,proceedToCheckout);
        return new PaymentPage();
    }




}
