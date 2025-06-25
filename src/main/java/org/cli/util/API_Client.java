package org.cli.util;

import java.io.IOException;

public class API_Client {
    private static final String BASE_URL = "http://localhost:8080/api";
    private static HttpClient httpClient = new DefaultHttpClient();
    
    public static void setHttpClient(HttpClient client) {
        httpClient = client;
    }
    
    public static String get(String endpoint) {
        if (endpoint == null) {
            return "ERROR: Endpoint cannot be null";
        }
        try {
            return httpClient.get(BASE_URL + endpoint);
        } catch (IOException e) {
            return "ERROR: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "ERROR: Invalid URL - " + e.getMessage();
        }
    }
} 