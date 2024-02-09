package com.automationexercise.tests;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactAsFormTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button
        5. Verify 'GET IN TOUCH' is visible
        6. Enter name, email, subject and message
        7. Upload file
        8. Click 'Submit' button
        9. Click OK button
        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test(description = "Test Case 6: Contact Us Form")
    public void contactUsFormTest() throws IOException, ParseException {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        verifyGetInTouchIsVisible();
        verifySuccessMessageIsVisible();
        verifyThatLandedToHomePageSuccessfully();
    }

    /* Steps */

    public void verifyGetInTouchIsVisible() {
        boolean visibleGetInTouchText = new HomePage(driver)
                .contactUsMenuBtnClick()
                .getGetInTouchLabel()
                .getText()
                .contains("CONTACT US");
        Assert.assertTrue(visibleGetInTouchText);
    }

    public void  verifySuccessMessageIsVisible() throws IOException, ParseException {
        boolean visibleSuccessMessage = new ContactUsPage(driver)
                .fillContactUsForm()
                .successSendMessageTxt()
                .getText()
                .contains("Success! Your details have been submitted successfully.");
        Assert.assertTrue(visibleSuccessMessage);
    }

    public void verifyThatLandedToHomePageSuccessfully() {
        boolean visibleHomePage = new ContactUsPage(driver)
                .backToHomePageBtnClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(visibleHomePage);
    }
}
