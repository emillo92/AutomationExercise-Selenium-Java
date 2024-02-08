package com.automationexercise.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    static Properties properties;

    static FileInputStream prodData;

    public static String loadProperty(String propertyName) throws IOException {
        properties = new Properties();
        prodData = new FileInputStream("src/main/resources/config.properties");
        properties.load(prodData);
        return properties.getProperty(propertyName);
    }
}
