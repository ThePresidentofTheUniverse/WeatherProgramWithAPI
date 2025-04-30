import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ZipToCountry {


        public static String[] CountryZipCode (String countryAB, String zipCode){

            String[] zipList = new String[4]; //Uses an array list to return all items
            /* 0 = latitude
               1 = longitude
               2 = country
               3 = city
             */

            try {
                String apiurl = "https://api.zippopotam.us/" + countryAB + "/" + zipCode; //One of them allows the country initials to be entered, other is for zipcode
                URL url = new URL(apiurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                //Doing response code stuff
                int response = conn.getResponseCode();
                if (response == 200){
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();

                    while((inputLine = in.readLine()) != null){
                        content.append(inputLine);
                    }
                    in.close();
                    conn.disconnect();

                    //Parsing the response here.
                    JSONObject jsonResponse = new JSONObject(content.toString());
                    zipList[0] = jsonResponse.getJSONArray("places").getJSONObject(0).getString("latitude"); //latitude
                    zipList[1] = jsonResponse.getJSONArray("places").getJSONObject(0).getString("longitude"); //longitude
                    zipList[2] = jsonResponse.getString("country"); //country
                   zipList[3] = jsonResponse.getJSONArray("places").getJSONObject(0).getString("place name"); //city
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return zipList;
        }

}
