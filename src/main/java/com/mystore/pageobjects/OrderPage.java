package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath = "//li[@class='price']")
    WebElement unitPrice;

    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckout;

    public OrderPage() {
        PageFactory.initElements(driver,this);
    }

    public double getUnitPrice() {
      String unitPrice1 = unitPrice.getText();
      String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
      double finalUnitPrice = Double.parseDouble(unit);
      return finalUnitPrice/100;
    }

    public double getTotalPrice() {
        String unitPrice1 = unitPrice.getText();
        String tot = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public LoginPage clickOnCheckout() {
        action.click(driver, proceedToCheckout);
        return new LoginPage();
    }



}
