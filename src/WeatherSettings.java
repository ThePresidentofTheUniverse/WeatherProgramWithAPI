import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WeatherSettings {

    public static void main(String[] args) { //for testing purposes

        double[] weatherList = WeatherSettings.weatherChecker(52.52, 13.41);

        int index = 0;
        for (Double d : weatherList){
            System.out.println(index +": " + weatherList[index]);
            index++;
        }

    }

    //The conglomerate method is used below to grab all information and transform the data into seven-days
    // instead of 24 hour periods (168 hours total).

    public static double[] weatherChecker (double latitude, double longitude){

        int index = 0;
        //All raw items below, instead of using hourly forecast, I want to do seven, day forecasts.
        double[] rawTemp = new double[167];
        double[] rawWindSpeed = new double[167];
        double[] rawSnow = new double[167];
        double[] rawShowers = new double[167];
        double[] rawRain = new double[167];
        double[] rawWindDirect = new double[167];



        try {
            String apiurl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,wind_speed_10m,snowfall,showers,rain,wind_direction_10m"; //The URL
            URL url = new URL (apiurl);
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
                //temperature
              for (double d : rawTemp){
                  if (jsonResponse != null) {
                      rawTemp[index] = jsonResponse.getJSONObject("hourly").getJSONArray("temperature_2m").getDouble(index);
                      index++;
                  }
              }

              //windspeed
                index = 0; //resets index
                for (double d : rawWindSpeed){
                    if (jsonResponse != null){
                        rawWindSpeed[index] = jsonResponse.getJSONObject("hourly").getJSONArray("wind_speed_10m").getDouble(index);
                        index++;
                    }
                }

                //snowfall
                index = 0; //resets index
                for (double d : rawSnow){
                    if (jsonResponse != null){
                        rawSnow[index] = jsonResponse.getJSONObject("hourly").getJSONArray("snowfall").getDouble(index);
                        index++;
                    }
                }

                //showers
                index = 0; //resets index
                for (double d: rawShowers){
                    if (jsonResponse != null){
                        rawShowers[index] = jsonResponse.getJSONObject("hourly").getJSONArray("showers").getDouble(index);
                        index++;
                    }
                }

                //rain
                index = 0; //resets index
                for (double d: rawRain){
                    if (jsonResponse != null){
                        rawRain[index] = jsonResponse.getJSONObject("hourly").getJSONArray("rain").getDouble(index);
                        index++;
                    }
                }
                //wind direction
                index = 0; //resets index
                for (double d: rawWindDirect){
                    if (jsonResponse != null){
                        rawWindDirect[index] = jsonResponse.getJSONObject("hourly").getJSONArray("wind_direction_10m").getDouble(index);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      return;
    }
}
