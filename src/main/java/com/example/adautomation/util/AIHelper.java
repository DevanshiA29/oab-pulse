package com.example.adautomation.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AIHelper {

    // API details
    private static final String API_URL = "https://api-inference.huggingface.co/models/distilgpt2"; // Updated API URL for structured responses
    private static final String API_KEY = "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"; // Replace with your Hugging Face API key

    /**
     * Sends a request to the Hugging Face API for AI analysis based on the input prompt.
     *
     * @param prompt The text prompt to send to the AI model.
     * @return The AI-generated response in numbered points or an error message if the request fails.
     */
    public static String getAIAnalysis(String prompt) {
        try {
            // Add instruction for structured response
            prompt += "\n\nPlease provide only concise marketing strategies in numbered points without including irrelevant text or explanations.";

            // Initialize the connection
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Prepare the JSON payload
            JSONObject payload = new JSONObject();
            payload.put("inputs", prompt); // Key for Hugging Face API

            // Send the request payload
            try (OutputStream os = connection.getOutputStream()) {
                os.write(payload.toString().getBytes("UTF-8"));
            }

            // Read and handle the API response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the successful response
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();

                // Parse the JSON response
                JSONArray jsonResponse = new JSONArray(response.toString());
                if (jsonResponse.length() > 0) {
                    JSONObject firstResponse = jsonResponse.getJSONObject(0); // Get the first response
                    String aiResponse = firstResponse.optString("generated_text", "No response from AI model.");

                    // Format response into numbered points
                    String[] lines = aiResponse.split("\\. "); // Split by periods for point detection
                    StringBuilder formattedResponse = new StringBuilder();
                    int count = 1;
                    for (String lineItem : lines) {
                        if (!lineItem.trim().isEmpty()) { // Ignore empty or irrelevant lines
                            formattedResponse.append(count++).append(". ").append(lineItem.trim()).append("\n");
                        }
                    }
                    return formattedResponse.toString().trim();
                } else {
                    return "No response from AI model.";
                }
            } else {
                // Handle errors by reading the error stream
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    errorResponse.append(line);
                }
                br.close();
                System.err.println("Error Response Body: " + errorResponse.toString());
                return "Error: " + responseCode + " - " + errorResponse.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Unable to process the request.";
        }
    }

}
