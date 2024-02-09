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

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    private WebElement errorEmailAddressAlreadyExist;

    public WebElement newUserSingUpLabelIsVisible() {
        return newUserSignUpLabel;
    }

    public WebElement getLoginLabel() {
        return loginLabel;
    }

    public WebElement getErrorIncorrectLoginData() {
        return errorIncorrectLoginData;
    }

    public WebElement getErrorEmailAddressAlreadyExist() {
        return errorEmailAddressAlreadyExist;
    }

    private void fillSignUp(String name, String email) {
        singUpName.sendKeys(name);
        singUpEmail.sendKeys(email);
        singUpBtn.click();
    }

    private void fillLogin(String login, String password) {
        loginEmailInput.sendKeys(login);
        loginPasswordInput.sendKeys(password);
        loginBtn.click();
    }

    public EnterAccountInformationPage fillSignUp() throws IOException, ParseException {
        fillSignUp(JSONDataReader.createAccountData("singUpName"), JSONDataReader.createAccountData("singUpEmail"));
        return new EnterAccountInformationPage(driver);
    }

    public SignUpLoginPage fillSignUpWithExistingUserLoginData() throws IOException, ParseException {
        fillSignUp(JSONDataReader.loginData("existingUserName"), JSONDataReader.loginData("existingUserEmail"));
        return new SignUpLoginPage(driver);
    }

    public HomePage fillLoginCorrectData() throws IOException, ParseException {
        fillLogin(JSONDataReader.loginData("correctEmail"), JSONDataReader.loginData("correctPassword"));
        return new HomePage(driver);
    }

    public SignUpLoginPage fillLoginIncorrectData() throws IOException, ParseException {
        fillLogin(JSONDataReader.loginData("incorrectEmail"), JSONDataReader.loginData("incorrectPassword"));
        return new SignUpLoginPage(driver);
    }

    public HomePage fillLoginForAnotherAccount() throws IOException, ParseException {
        fillLogin(JSONDataReader.loginData("existingUserEmail"), JSONDataReader.loginData("existingUserPassword"));
        return new HomePage(driver);
    }
}
