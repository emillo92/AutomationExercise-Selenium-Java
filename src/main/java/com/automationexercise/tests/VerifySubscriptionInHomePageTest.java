package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifySubscriptionInHomePageTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Scroll down to footer
        5. Verify text 'SUBSCRIPTION'
        6. Enter email address in input and click arrow button
        7. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test(description = "Test Case 10: Verify Subscription in home page")
    public void verifySubscriptionInHomePageTest() throws IOException, ParseException {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        verifyTextSubscriptionOnHomePage();
        verifySuccessMessageIsVisible();
    }

    public void verifyTextSubscriptionOnHomePage() {
        String textSubscriptionOnHomePage = new HomePage(driver)
                .subscriptionLabel()
                .getText();
        Assert.assertEquals(textSubscriptionOnHomePage, "SUBSCRIPTION");
    }

    public void verifySuccessMessageIsVisible() throws IOException, ParseException {
        String successMessage = new HomePage(driver)
                .fillSubscribeDetails()
                .successSubscriptionLabel()
                        .getText();
        Assert.assertEquals(successMessage, "You have been successfully subscribed!");
    }
}
