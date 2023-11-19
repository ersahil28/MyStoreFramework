package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    Action action = new Action();

    @FindBy (xpath = "//h1[@class='page-heading']")
    WebElement formTitle;

    public AccountCreationPage() {
        PageFactory.initElements(driver,this);
    }

    public boolean validateAccountCreatePage() {
        return action.isDisplayed(driver,formTitle);
    }

}
