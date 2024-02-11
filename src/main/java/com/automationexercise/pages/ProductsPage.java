package com.automationexercise.pages;

import com.automationexercise.utils.JSONDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
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

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchProductInput;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement submitSearchBtn;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    private WebElement searchedProductsLabel;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p[contains(text(),'Fancy Green Top')]")
    private WebElement productName;

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

    public ProductsPage fillSearch() throws IOException, ParseException {
        searchProductInput.sendKeys(JSONDataReader.searchProductData("productName"));
        submitSearchBtn.click();
        return new ProductsPage(driver);
    }

    public WebElement searchedProductsLabel() {
        return searchedProductsLabel;
    }

    public WebElement productName() {
        return productName;
    }
}
