package com.skillstorm.helper;

import java.net.HttpURLConnection;
import java.net.URL;

public class ResetDB {
    
        public static void sendPost() {
        String resetDataURI = "http://localhost:8080/resetdb";
        try {
            // URL to send the POST request to
            URL url = new URL(resetDataURI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            
            // get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // catch error
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        };
    }
}