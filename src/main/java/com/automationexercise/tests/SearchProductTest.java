package com.automationexercise.tests;

import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.JSONDataReader;
import com.automationexercise.utils.SetupBrowser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProductTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Products' button
        5. Verify user is navigated to ALL PRODUCTS page successfully
        6. Enter product name in search input and click search button
        7. Verify 'SEARCHED PRODUCTS' is visible
        8. Verify all the products related to search are visible
     */

    @Test(description = "Test Case 9: Search Product")
    public void searchProductTest() throws IOException, ParseException {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        VerifyAllProductsAndProductDetailPageTest.verifyThatAllProductPageIsVisible();
        verifySearchedProductsTextAreVisible();
        verifyAllSearchedProductAreVisible();
    }

    public void verifySearchedProductsTextAreVisible() throws IOException, ParseException {
        String visibleSearchedProductsLabel = new ProductsPage(driver)
                .fillSearch()
                .searchedProductsLabel()
                .getText();
        Assert.assertEquals(visibleSearchedProductsLabel, "SEARCHED PRODUCTS");
    }

    public void verifyAllSearchedProductAreVisible() throws IOException, ParseException {
        String visibleSearchedProduct = new ProductsPage(driver)
                .productName().getText();
        Assert.assertEquals(visibleSearchedProduct, JSONDataReader.searchProductData("productName"));
    }
}
