package com.automationexercise.pages;

import com.automationexercise.utils.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Arrays;

public class EnterAccountInformationPage {

    WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    private WebElement enterAccountInformationLabel;

    @FindBy(css = "#id_gender1")
    private WebElement maleRadioBtn;

    @FindBy(css = "#id_gender2")
    private WebElement femaleRadioBtn;

    @FindBy(css = "#name")
    private WebElement nickName;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#days")
    private WebElement days;

    @FindBy(css = "#months")
    private WebElement months;

    @FindBy(css = "#years")
    private WebElement years;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement specialOffers;

    @FindBy(css = "#first_name")
    private WebElement firstName;

    @FindBy(css = "#last_name")
    private WebElement lastName;

    @FindBy(css = "#address1")
    private WebElement addressFirstLine;

    @FindBy(css = "#address2")
    private WebElement addressLastLine;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#state")
    private WebElement state;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#zipcode")
    private WebElement zipcode;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    private WebElement createAccountBtn;

    public WebElement EnterAccountInformationLabel() {
        return enterAccountInformationLabel;
    }

    public AccountCreatedPage fillAccountInformation() throws IOException, ParseException {
        genderType();
        password.sendKeys(JSONDataReader.createAccountData("password"));
        Select day = new Select(days);
        day.selectByValue(JSONDataReader.createAccountData("days"));
        Select month = new Select(months);
        month.selectByValue(JSONDataReader.createAccountData("months"));
        Select year = new Select(years);
        year.selectByValue(JSONDataReader.createAccountData("years"));
        newsletter.click();
        specialOffers.click();
        firstName.sendKeys(JSONDataReader.createAccountData("firstName"));
        lastName.sendKeys(JSONDataReader.createAccountData("lastName"));
        addressFirstLine.sendKeys(JSONDataReader.createAccountData("addressFirstLine"));
        Select land = new Select(country);
        land.selectByValue(JSONDataReader.createAccountData("country"));
        state.sendKeys(JSONDataReader.createAccountData("state"));
        city.sendKeys(JSONDataReader.createAccountData("city"));
        zipcode.sendKeys(JSONDataReader.createAccountData("zipcode"));
        mobileNumber.sendKeys(JSONDataReader.createAccountData("mobileNumber"));
        createAccountBtn.click();

        return new AccountCreatedPage(driver);
    }


    private void genderType() {
        String[] vowels = {"a", "ą", "e", "ę", "i", "o", "u", "ó", "y"};

        String name = nickName.toString();
        String lastChar = String.valueOf(name.charAt(name.length() - 1));

        Arrays.stream(vowels).forEach(s -> {
            if (s.equals(lastChar)) {
                femaleRadioBtn.click();
            } else maleRadioBtn.click();
        });
    }
}
