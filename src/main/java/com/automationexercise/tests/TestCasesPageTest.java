package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.SetupBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesPageTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Test Cases' button
        5. Verify user is navigated to test cases page successfully
     */

    @Test(description = "Test Case 7: Verify Test Cases Page")
    public void testCasesPageTest() {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToTestCasesPageSuccessfully();
    }

    /* Steps */

    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        boolean userIsNavigatedToTestCasesPage = new HomePage(driver)
                .testCasesMenuBtnClick()
                .testCasesLabel()
                .isDisplayed();
        Assert.assertTrue(userIsNavigatedToTestCasesPage);
    }
}
