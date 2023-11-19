package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    WebElement confirmOrderBtn;



    public OrderSummary() {
        PageFactory.initElements(driver,this);
    }

    public OrderConfirmationPage clickOnConfirmButton() {
        action.click(driver,confirmOrderBtn);
        return new OrderConfirmationPage();
    }

}
