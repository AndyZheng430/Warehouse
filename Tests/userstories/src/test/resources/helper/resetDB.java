package resources;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class resetDB {
    
        public static sendPost() {
        string resetDataURI = "http://localhost:8080/warehouses/delete"
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