package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//span[normalize-space()='Order history and details']")
    WebElement orderHistory;

    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateOrderHistory() {
        return action.isDisplayed(getDriver(),orderHistory);

    }

    public String getCurrentUrl() {
        String homePageUrl = getDriver().getCurrentUrl();
        return homePageUrl;

    }

}
