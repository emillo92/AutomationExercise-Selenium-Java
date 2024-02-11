package com.automationexercise.pages;

import com.automationexercise.utils.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='slider']")
    private WebElement slider;

    @FindBy(css = "a[href='/login']")
    private WebElement signUpLoginBtn;

    @FindBy(partialLinkText = "Logged in")
    private WebElement loggedInAsTxt;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountMenuBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsMenuBtn;

    @FindBy(xpath = "//a[@href='/test_cases']")
    private WebElement testCasesMenuBtn;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsMenuBtn;

    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    private WebElement subscriptionLabel;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement subscribeEmailInput;

    @FindBy(xpath = "//button[@id='subscribe']")
    private WebElement subscribeBtn;

    @FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    private WebElement successSubscriptionLabel;

    public WebElement homePageIsVisible() {
        return slider;
    }

    public SignUpLoginPage signUpButtonClick() {
        signUpLoginBtn.click();
        return new SignUpLoginPage(driver);
    }

    public WebElement loggedInAsTxt() {
        return loggedInAsTxt;
    }

    public AccountDeletePage deleteAccountBtnClick() {
        deleteAccountMenuBtn.click();
        return new AccountDeletePage(driver);
    }

    public SignUpLoginPage logoutBtnClick() {
        logoutBtn.click();
        return new SignUpLoginPage(driver);
    }

    public ContactUsPage contactUsMenuBtnClick() {
        contactUsMenuBtn.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesMenuBtnClick() {
        testCasesMenuBtn.click();
        return new TestCasesPage(driver);
    }

    public ProductsPage productMenuBtnClick() {
        productsMenuBtn.click();
        return new ProductsPage(driver);
    }

    public WebElement subscriptionLabel() {
        return subscriptionLabel;
    }

    public HomePage fillSubscribeDetails() throws IOException, ParseException {
        subscribeEmailInput.sendKeys(JSONDataReader.subscribeData("subscribeEmail"));
        subscribeBtn.click();
        return new HomePage(driver);
    }

    public WebElement successSubscriptionLabel() {
        return successSubscriptionLabel;
    }
}
