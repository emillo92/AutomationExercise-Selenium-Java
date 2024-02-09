package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutUserTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Logout' button
        10. Verify that user is navigated to login page
     */

    @Test(description = "Test Case 4: Logout User")
    public void logoutUserTest() throws IOException, ParseException {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        CorrectLoginUserTest.verifyLoginToYourAccountIsVisible();
        verifyThatLoggedInAsUserNameIsVisible();
        verifyThatUserIsNavigatedToLoginPage();
    }

    /* Steps */

    public void verifyThatLoggedInAsUserNameIsVisible() throws IOException, ParseException {
        boolean loggedInAsUserName = new SignUpLoginPage(driver)
                .fillLoginForAnotherAccount()
                .loggedInAsTxt()
                .isDisplayed();
        Assert.assertTrue(loggedInAsUserName);
    }

    public void verifyThatUserIsNavigatedToLoginPage() {
        boolean verifyLogoutUser = new HomePage(driver)
                .logoutBtnClick()
                .getLoginLabel()
                .isDisplayed();
        Assert.assertTrue(verifyLogoutUser);
    }
}
