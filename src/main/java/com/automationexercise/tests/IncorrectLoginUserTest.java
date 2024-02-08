package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class IncorrectLoginUserTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
     */

    @Test(description = "Test Case 3: Login User with incorrect email and password")
    public void incorrectLoginUserTest() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyLoginToYourAccountIsVisible();
        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
    }

    /* Steps */

    public void verifyThatHomePageIsVisibleSuccessfully() {
        boolean visibleHomePage = new HomePage(driver)
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleHomePage);
    }

    public void verifyLoginToYourAccountIsVisible() {
        boolean visibleLoginToYourAccountTxt = new HomePage(driver)
                .signUpButtonClick()
                .getLoginLabel()
                .isDisplayed();
        Assert.assertTrue(visibleLoginToYourAccountTxt);
    }

    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() throws IOException, ParseException {
        boolean errorIncorrectEmailOrPassword = new SignUpLoginPage(driver)
                .fillLoginIncorrectData()
                .getErrorIncorrectLoginData()
                .isDisplayed();
        Assert.assertTrue(errorIncorrectEmailOrPassword);
    }
}
