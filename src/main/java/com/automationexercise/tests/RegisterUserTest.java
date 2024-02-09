package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterUserTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and email address
        7. Click 'Signup' button
        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        9. Fill details: Title, Name, Email, Password, Date of birth
        10. Select checkbox 'Sign up for our newsletter!'
        11. Select checkbox 'Receive special offers from our partners!'
        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        13. Click 'Create Account button'
        14. Verify that 'ACCOUNT CREATED!' is visible
        15. Click 'Continue' button
        16. Verify that 'Logged in as username' is visible
        17. Click 'Delete Account' button
        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test(description = "Test Case 1: Register User")
    public void registerUser() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyNewUserSignupIsVisible();
        verifyThatEnterAccountInformationIsVisible();
        verifyThatAccountCreatedIsVisible();
        verifyThatLoggedInAsUserNameIsVisible();
        verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    /* Steps */

    public static void verifyThatHomePageIsVisibleSuccessfully() {
        boolean visibleHomePage = new HomePage(driver)
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleHomePage);
    }

    public static void verifyNewUserSignupIsVisible() {
        boolean visibleNewUserSinUp = new HomePage(driver)
                .signUpButtonClick()
                .newUserSingUpLabelIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleNewUserSinUp);
    }

    public void verifyThatEnterAccountInformationIsVisible() throws IOException, ParseException {

        boolean visibleEnterAccountInformation = new SignUpLoginPage(driver)
                .fillSignUp()
                .EnterAccountInformationLabel()
                .isDisplayed();
        Assert.assertTrue(visibleEnterAccountInformation);
    }

    public void verifyThatAccountCreatedIsVisible() throws IOException, ParseException {
        String visibleAccountCreatedText = new EnterAccountInformationPage(driver)
                .fillAccountInformation()
                .accountCreatedTxt()
                .getText();
        Assert.assertEquals(visibleAccountCreatedText, "ACCOUNT CREATED!");
    }

    public void verifyThatLoggedInAsUserNameIsVisible() {
        boolean visibleLoggedInAsUserNameTxt = new AccountCreatedPage(driver)
                .loggedIsAs()
                .loggedInAsTxt()
                .isDisplayed();
        Assert.assertTrue(visibleLoggedInAsUserNameTxt);
    }

    public void verifyThatAccountDeletedIsVisibleAndClickContinueButton() {
        boolean visibleAccountDeleteTxt = new HomePage(driver)
                .deleteAccountBtnClick()
                .accountDeletedTxt()
                .isDisplayed();
        Assert.assertTrue(visibleAccountDeleteTxt);

        boolean continueBtnClick = new AccountDeletePage(driver)
                .accountDeletedContinueClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(continueBtnClick);
    }
}
