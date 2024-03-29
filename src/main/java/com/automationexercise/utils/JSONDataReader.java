package com.automationexercise.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONDataReader {

    public static String createAccountData(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/TestData/CreateAccountData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject createAccountData = (JSONObject) obj;
        return (String)createAccountData.get(data);
    }

    public static String loginData(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/TestData/LoginData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject loginData = (JSONObject) obj;
        return (String)loginData.get(data);
    }

    public static String contactFormData(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/TestData/ContactFormData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject contactFormData = (JSONObject) obj;
        return (String)contactFormData.get(data);
    }

    public static String searchProductData(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/TestData/SearchProductData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject searchProductData = (JSONObject) obj;
        return (String)searchProductData.get(data);
    }

    public static String subscribeData(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/main/resources/TestData/SubscribeData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject subscribeData = (JSONObject) obj;
        return (String)subscribeData.get(data);
    }
}
