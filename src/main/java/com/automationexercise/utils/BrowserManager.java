package com.automationexercise.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class BrowserManager {

    public static WebDriver loadDriver() throws IOException {

        WebDriver driver = null;

        String browserName = PropertiesLoader.loadProperty("browser.name");

        switch (browserName) {

            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                String pathExtension = PropertiesLoader.loadProperty("chrome.extension.adblock.path");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins");
                options.addArguments("load-extension=" + pathExtension);
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "internet explorer" -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
            default -> System.out.println("Browser " + browserName + " is not supported. Please change browser.");
        }

        driver.manage().window().maximize();

        return driver;
    }
}
