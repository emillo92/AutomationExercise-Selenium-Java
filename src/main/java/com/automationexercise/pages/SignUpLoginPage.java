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

    public WebElement newUserSingUpLabelIsVisible() {
        return newUserSignUpLabel;
    }

    public EnterAccountInformationPage fillSignUp() throws IOException, ParseException {
        singUpName.sendKeys(JSONDataReader.createAccountData("singUpName"));
        singUpEmail.sendKeys(JSONDataReader.createAccountData("singUpEmail"));
        singUpBtn.click();
        return new EnterAccountInformationPage(driver);
    }

}
