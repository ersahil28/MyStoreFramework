package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantity;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement size;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement addToCartMessage;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public void enterQuantity(String quantity1){
        action.type(quantity,quantity1);
    }

    public  void selectSize(String size1) {
        action.selectByVisibleText(size1,size);
    }

    public void clickOnAddToCart() {
        action.click(getDriver(),addToCartBtn);
    }

    public boolean validateAddToCart() {
        action.fluentWait(getDriver(),addToCartMessage,10);
        return action.isDisplayed(getDriver(),addToCartMessage);
    }

    public OrderPage clickOnCheckout() {
        action.fluentWait(getDriver(),proceedToCheckoutBtn,10);
        action.JSClick(getDriver(),proceedToCheckoutBtn);
        return new OrderPage();
    }


}
