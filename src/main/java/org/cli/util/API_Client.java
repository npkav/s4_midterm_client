package org.cli.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_Client {
    private static final String BASE_URL = "http://localhost:8080/api";
    
    private static String sendRequest(String endpoint, String method, String json) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", "application/json");

            if (json != null) {
                conn.setRequestProperty("Content-Type", "application/json; utf-8");
                conn.setDoOutput(true);
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = json.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {result.append(line);}
            reader.close();
            return result.toString();
        } catch (Exception e) {return "ERROR: " + e.getMessage();}
    }

    public static String get(String endpoint) {return sendRequest(endpoint, "GET", null);}
    public static String post(String endpoint, String json) {return sendRequest(endpoint, "POST", json);}
    public static String put(String endpoint, String json) {return sendRequest(endpoint, "PUT", json);}
    public static void delete(String endpoint) {sendRequest(endpoint, "DELETE", null);}
} 