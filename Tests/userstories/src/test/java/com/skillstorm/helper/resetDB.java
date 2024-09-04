package com.skillstorm.helper;

import java.net.HttpURLConnection;
import java.net.URL;

public class resetDB {
    
        public static void sendPost() {
        String resetDataURI = "http://team8-frontend.s3-website-us-east-1.amazonaws.com/test/resetDB";
        try {
            // URL to send the POST request to
            URL url = new URL(resetDataURI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            

            connection.setRequestMethod("POST");
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