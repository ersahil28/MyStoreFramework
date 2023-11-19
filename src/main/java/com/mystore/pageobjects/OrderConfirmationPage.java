package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {


    Action action = new Action();

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement confirmMessage;


    public OrderConfirmationPage() {
        PageFactory.initElements(driver,this);
    }

    public String validateConfirmMessage() {
        String confirmMsg =  confirmMessage.getText();
        return confirmMsg;
    }

}
