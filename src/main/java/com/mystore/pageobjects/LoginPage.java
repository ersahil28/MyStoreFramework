package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action action = new Action();

    @FindBy(xpath="//input[@id='email']")
    WebElement username;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInBtn;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailForNewAccount;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createNewAccountBtn;


    public LoginPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public AddressPage login1(String uname, String pswd) {
        action.type(username,uname);
        action.type(password,pswd);
        action.click(getDriver(),signInBtn);
        return new AddressPage();
    }

    public HomePage login(String uname, String pswd) {
        action.type(username,uname);
        action.type(password,pswd);
        action.click(getDriver(),signInBtn);
        return new HomePage();
    }

    public AccountCreationPage createNewAccount(String newEmail) {
        action.type(emailForNewAccount,newEmail);
        action.click(getDriver(),createNewAccountBtn);
        return new AccountCreationPage();
    }

}
