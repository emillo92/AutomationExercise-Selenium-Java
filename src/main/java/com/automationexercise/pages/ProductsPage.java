package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    private WebElement allProductsLabel;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    private List<WebElement> productImageWrapper = new ArrayList<>();

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductLink;

    public WebElement allProductsLabel() {
        return allProductsLabel;
    }

    public List<WebElement> ProductImageWrapper() {
        return productImageWrapper;
    }

    public ProductDetailsPage viewProductClick() {
        viewProductLink.click();
        return new ProductDetailsPage(driver);
    }

}
