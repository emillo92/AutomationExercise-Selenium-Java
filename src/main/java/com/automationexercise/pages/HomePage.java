package com.automationexercise.pages;

import com.automationexercise.tests.TestCasesPageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
