package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    private WebElement accountCreatedTxt;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement continueBtn;

    public WebElement accountCreatedTxt() {
        return accountCreatedTxt;
    }

    public HomePage loggedIsAs() {
        continueBtn.click();
        return new HomePage(driver);
    }
}
