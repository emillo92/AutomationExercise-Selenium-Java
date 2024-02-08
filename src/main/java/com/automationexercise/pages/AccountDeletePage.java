package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletePage {

    WebDriver driver;

    public AccountDeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//b[contains(text(),'Account Deleted!')]")
    private WebElement accountDeletedTxt;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement continueBtn;

    public WebElement accountDeletedTxt() {
        return accountDeletedTxt;
    }

    public HomePage accountDeletedContinueClick() {
        continueBtn.click();
        return new HomePage(driver);
    }
}
