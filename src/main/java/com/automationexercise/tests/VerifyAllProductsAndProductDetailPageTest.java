package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.SetupBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailPageTest extends SetupBrowser {

    /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Products' button
        5. Verify user is navigated to ALL PRODUCTS page successfully
        6. The products list is visible
        7. Click on 'View Product' of first product
        8. User is landed to product detail page
        9. Verify that detail is visible: product name, category, price, availability, condition, brand
     */
    @Test(description = "Verify All Products and product detail page")
    public void verifyAllProductsAndProductDetailPageTest() {
        RegisterUserTest.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatAllProductPageIsVisible();
        verifyThatProductListIsVisible();
        VerifyThatDetailSingleProductIsVisible();
    }

    /* Steps */

    public void verifyThatAllProductPageIsVisible() {
        boolean visibleProductList = new HomePage(driver)
                .productMenuBtnClick()
                .allProductsLabel()
                .getText().equals("ALL PRODUCTS");
        Assert.assertTrue(visibleProductList);
    }

    public void verifyThatProductListIsVisible() {
        boolean productList = new ProductsPage(driver)
                .ProductImageWrapper()
                .isEmpty();
        Assert.assertFalse(productList);
    }

    public void VerifyThatDetailSingleProductIsVisible() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.viewProductClick();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        Assert.assertTrue(productDetailsPage.getProductName().isDisplayed());
        Assert.assertTrue(productDetailsPage.getCategoryName().isDisplayed());
        Assert.assertTrue(productDetailsPage.getPrice().isDisplayed());
        Assert.assertTrue(productDetailsPage.getAvailability().isDisplayed());
        Assert.assertTrue(productDetailsPage.getCondition().isDisplayed());
        Assert.assertTrue(productDetailsPage.getBrandName().isDisplayed());
    }
}
