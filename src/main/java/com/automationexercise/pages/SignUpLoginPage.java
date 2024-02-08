package com.automationexercise.pages;

import com.automationexercise.utils.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignUpLoginPage {
    WebDriver driver;

    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    private WebElement newUserSignUpLabel;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement singUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement singUpEmail;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    private WebElement singUpBtn;

    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    private WebElement loginLabel;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement errorIncorrectLoginData;

    public WebElement newUserSingUpLabelIsVisible() {
        return newUserSignUpLabel;
    }

    public WebElement getLoginLabel() {
        return loginLabel;
    }

    public WebElement getErrorIncorrectLoginData() {
        return errorIncorrectLoginData;
    }

    public EnterAccountInformationPage fillSignUp() throws IOException, ParseException {
        singUpName.sendKeys(JSONDataReader.createAccountData("singUpName"));
        singUpEmail.sendKeys(JSONDataReader.createAccountData("singUpEmail"));
        singUpBtn.click();
        return new EnterAccountInformationPage(driver);
    }

    public HomePage fillLoginCorrectData() throws IOException, ParseException {
        loginEmailInput.sendKeys(JSONDataReader.loginData("correctEmail"));
        loginPasswordInput.sendKeys(JSONDataReader.loginData("correctPassword"));
        loginBtn.click();
        return new HomePage(driver);
    }

    public SignUpLoginPage fillLoginIncorrectData() throws IOException, ParseException {
        loginEmailInput.sendKeys(JSONDataReader.loginData("incorrectEmail"));
        loginPasswordInput.sendKeys(JSONDataReader.loginData("incorrectPassword"));
        loginBtn.click();
        return new SignUpLoginPage(driver);
    }
}
