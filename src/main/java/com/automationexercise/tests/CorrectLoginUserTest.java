package com.automationexercise.tests;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignUpLoginPage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CorrectLoginUserTest extends SetupBrowser {

   /*
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter correct email address and password
      7. Click 'login' button
      8. Verify that 'Logged in as username' is visible
      9. Click 'Delete Account' button
       10. Verify that 'ACCOUNT DELETED!' is visible
   */

    @Test(description = "Test Case 2: Login User with correct email and password")
    public void correctLoginUserTest() throws IOException, ParseException {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        verifyLoginToYourAccountIsVisible();
        verifyThatLoggedIsAsUsernameIsVisible();
        verifyThatAccountDeletedIsVisible();
    }

    /* Steps */

    public static void verifyLoginToYourAccountIsVisible() {
        boolean visibleLoginToYourAccountTxt = new HomePage(driver)
                .signUpButtonClick()
                .getLoginLabel()
                .isDisplayed();
        Assert.assertTrue(visibleLoginToYourAccountTxt);
    }

    public void verifyThatLoggedIsAsUsernameIsVisible() throws IOException, ParseException {
        boolean visibleLoggedInAsUserNameTxt = new SignUpLoginPage(driver)
                .fillLoginCorrectData()
                .loggedInAsTxt()
                .isDisplayed();
        Assert.assertTrue(visibleLoggedInAsUserNameTxt);
    }

    public void verifyThatAccountDeletedIsVisible() {
        boolean visibleAccountDeleteTxt = new HomePage(driver)
                .deleteAccountBtnClick()
                .accountDeletedTxt()
                .isDisplayed();
        Assert.assertTrue(visibleAccountDeleteTxt);
    }
}
