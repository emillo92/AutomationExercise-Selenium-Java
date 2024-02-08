package com.automationexercise.pages;

import com.automationexercise.utils.JSONDataReader;
import com.automationexercise.utils.PropertiesLoader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='contact-page']/div[1]/div[1]/div[1]/h2[1]")
    private WebElement getInTouchLabel;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInputText;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputText;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subject;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement message;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileBtn;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[2]")
    private WebElement successSendMessageTxt;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/a[1]/span[1]")
    private WebElement backToHomePageBtn;

    public WebElement getGetInTouchLabel() {
        return getInTouchLabel;
    }

    public WebElement successSendMessageTxt() {
        return successSendMessageTxt;
    }

    public WebElement backToHomePageBtn() {
        return backToHomePageBtn;
    }

    public ContactUsPage fillContactUsForm() throws IOException, ParseException {
        nameInputText.sendKeys(JSONDataReader.contactFormData("nameInputText"));
        emailInputText.sendKeys(JSONDataReader.contactFormData("emailInputText"));
        subject.sendKeys(JSONDataReader.contactFormData("subject"));
        message.sendKeys(JSONDataReader.contactFormData("message"));
        String fileDir = PropertiesLoader.loadProperty("user.directory.path"
                + "src\\main\\resources\\TestData\\sample.txt");
        submitBtn.click();
        driver.switchTo().alert().accept();
        return new ContactUsPage(driver);
    }

    public HomePage backToHomePageBtnClick() {
        backToHomePageBtn.click();
        return new HomePage(driver);
    }
}
