package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Blue Top')]")
    private WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category: Women > Tops')]")
    private WebElement categoryName;

    @FindBy(xpath = "//span[contains(text(),'Rs. 500')]")
    private WebElement price;

    @FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[2]")
    private WebElement availability;

    @FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[3]")
    private WebElement condition;

    @FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[4]")
    private WebElement brandName;

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getCategoryName() {
        return categoryName;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getAvailability() {
        return availability;
    }

    public WebElement getCondition() {
        return condition;
    }

    public WebElement getBrandName() {
        return brandName;
    }
}

