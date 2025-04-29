import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherSettings {

    public static void main(String[] args) { //for testing purposes

        String weatherList = WeatherSettings.weatherChecker(52.52, 13.41);

    }

    //The conglomerate method is used below to grab all information and transform the data into seven-days
    // instead of 24 hour periods (168 hours total).

    public static String weatherChecker (double latitude, double longitude){

        int index = 0;
        int sevenDayIndex = 0;

        //All raw items below, instead of using hourly forecast, I want to do seven, day forecasts.
        double[] rawTemp = new double[168];
        double[] rawWindSpeed = new double[168];
        double[] rawSnow = new double[168];
        double[] rawShowers = new double[168];
        double[] rawRain = new double[168];
        double[] rawWindDirect = new double[168]; //Wind direction will be converted into compass form later.

        //All compiled data, merged into seven day forecasts, thankfully, the API always starts at 00:00 for time.
        double setAverage = 0; //Storage fo chopping up raw data.
        double[] avgTemp = new double[7];
        double[] avgWindSpeed = new double[7];
        double[] avgSnow = new double[7];
        double[] avgShowers = new double[7];
        double[] avgRain = new double[7];
        double[] avgWindDirect = new double[7];

        //Converts all data into one, massive string, that is joined together by both pipes and slashes, has to be done this way as Java only allows one return value.
        String convertToString;
        String allInformation = "";

        try { //big try-catch statement that grabs a LOT of data.
            String apiurl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m,wind_speed_10m,snowfall,showers,rain,wind_direction_10m&temperature_unit=fahrenheit"; //The URL
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
                        index++;
                    }
                }
                index = 0; //resets index for later use.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //168 divided by 24 is 7.
        //A lot more for loops to get the information parsed
        // index % 24 == 0

        //Temperature
        for (double d : rawTemp) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgTemp[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
               sevenDayIndex++;
               setAverage = 0 + d;
            }
            index++;

        }

        //wind speed
        index = 0; //resets index
        setAverage = 0; //resets average;
        for (double d : rawWindSpeed) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgWindSpeed[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
                sevenDayIndex++;
                setAverage = 0 + d;
            }
            index++;

        }

        //snow fall
        index = 0; //resets index
        setAverage = 0; //resets average;
        for (double d : rawSnow) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgSnow[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
                sevenDayIndex++;
                setAverage = 0 + d;
            }
            index++;

        }

        //showers
        index = 0; //resets index
        setAverage = 0; //resets average;
        for (double d : rawShowers) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgShowers[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
                sevenDayIndex++;
                setAverage = 0 + d;
            }
            index++;

        }

        //rain
        index = 0; //resets index
        setAverage = 0; //resets average;
        for (double d : rawRain) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgRain[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
                sevenDayIndex++;
                setAverage = 0 + d;
            }
            index++;

        }

        //wind direction
        index = 0; //resets index
        setAverage = 0; //resets average;
        for (double d : rawWindDirect) {

            setAverage += d;

            if (index % 24 == 0 && index != 0 || index == 167) {
                avgWindDirect[sevenDayIndex] = Math.round((setAverage / 24) * 100.0) / 100.0 ;
                sevenDayIndex++;
                setAverage = 0 + d;
            }
            index++;

        }


        //This is the part that converts the data into the massive string, so it can be returned, because Java is not able to return multiple values.



      return allInformation;
    }
}
