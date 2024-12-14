package com.example.adautomation.util;

import java.util.Properties;

import org.springframework.stereotype.Component;

import java.io.InputStream;


@Component
public class ApiHelper {

    // Method to get the Google Ads API Key
    public static String getGoogleAdsApiKey() {
        return getApiKey("google_ads_api_key");
    }

    // Method to get the OpenAI API Key
    public static String getOpenAiApiKey() {
        return getApiKey("YOUR_HUGGINGFACE_API_KEY");
    }

    // Generalized method to fetch API keys from the properties file
    static String getApiKey(String key) {
        try (InputStream input = ApiHelper.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            prop.load(input);
            return prop.getProperty(key);
        } catch (Exception e) {
            throw new RuntimeException("Error loading API key for " + key + ": " + e.getMessage());
        }
    }
}
