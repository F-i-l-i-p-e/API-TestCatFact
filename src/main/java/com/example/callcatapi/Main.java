package com.example.callcatapi;

// Import classes
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws Exception {
        // API URL
        final String apiURL = "https://catfact.ninja/fact";

        // Open HTTP
        final HttpURLConnection connection = (HttpURLConnection) new URL(apiURL).openConnection();

        // Set HTTP
        connection.setRequestMethod("GET");

        // Set up reader
        final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Storage
        final StringBuilder content = new StringBuilder();
        String inputLine;

        // Read response
        while ((inputLine = reader.readLine()) != null) {
            content.append(inputLine);
        }

        // Close
        reader.close();
        connection.disconnect();

        // Create Gson instance
        final Gson gson = new Gson();

        // Parse JSON into object
        final CatFact catFact = gson.fromJson(content.toString(), CatFact.class);

        // Print
        System.out.println("Fact: " + catFact.fact);
    }
}

// CatFact class
class CatFact {
    public String fact;
}
