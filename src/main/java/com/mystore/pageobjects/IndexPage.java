package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    Action action = new Action();

    @FindBy(css= "a[class='login']")
    WebElement signInBtn;

    @FindBy(css = "img[alt='My Shop']")
    WebElement logoMyShop;

    @FindBy(css = "#search_query_top")
    WebElement searchProductBox;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchButton;

    public IndexPage() {
        PageFactory.initElements(getDriver(),this); // this means initialize all page objects here in page
    }

    public LoginPage clickOnSignIn() {
        action.click(getDriver(),signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() {
        return action.isDisplayed(getDriver(),logoMyShop);
    }

    public String getMyStoreTitle() {
        String myStoreTitle = getDriver().getTitle();
        return myStoreTitle;
    }

    public SearchResultPage searchProduct(String productName) {
        action.type(searchProductBox, productName);
        action.click(getDriver(),searchButton);
        return new SearchResultPage();
    }






}
