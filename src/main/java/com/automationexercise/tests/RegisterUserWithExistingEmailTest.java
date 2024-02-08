package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterUserWithExistingEmailTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and already registered email address
        7. Click 'Signup' button
        8. Verify error 'Email Address already exist!' is visible
     */

    @Test(description = "Test Case 5: Register User with existing email")
    public void registerUserWithExistingEmailTest() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyNewUserSignupIsVisible();
        verifyErrorEmailAddressAlreadyExistIsVisible();
    }

    public void verifyThatHomePageIsVisibleSuccessfully() {
        boolean visibleHomePage = new HomePage(driver)
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleHomePage);
    }

    public void verifyNewUserSignupIsVisible() {
        boolean visibleNewUserSinUp = new HomePage(driver)
                .signUpButtonClick()
                .newUserSingUpLabelIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleNewUserSinUp);
    }

    public void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
        String errorEmailAddressAlreadyExistIsVisible = new SignUpLoginPage(driver)
                .fillSignUpWithExistingUserLoginData()
                .getErrorEmailAddressAlreadyExist()
                .getText();
        Assert.assertEquals(errorEmailAddressAlreadyExistIsVisible, "Email Address already exist!");
    }
}
