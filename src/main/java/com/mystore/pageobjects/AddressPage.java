package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;



    public AddressPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public ShippingPage clickOnCheckout() {
        action.click(getDriver(),proceedToCheckout);
        return new ShippingPage();
    }


}
