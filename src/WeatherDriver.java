import java.util.List;
import java.util.Scanner;

/*----------------------------------------------------
 * Program Title: Weather Program With API Implementation
 * Author: Nolan Abbott
 * Start Date: [28/04/2025]
 * End Date: [change/change/2025]
 * Description: This is a program that allows its users to search up what the weather is like in different locations
 * with the use of zipcodes (and maybe country abbreviations, I'll have to see how far I can get within the time-span of
 * 1 week.
 * Usage / Issues: not available
 *-----------------------------------------------------
 */
public class WeatherDriver {

    public static void main(String[] args) {

        //Asks for user input
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the initials of a country: ");
        String countryInit = scan.nextLine().trim().toLowerCase();
        System.out.print("Please enter the desired zip code: ");
        String zipCode = scan.nextLine(); //Needs to be string because of some countries.
        System.out.println("What kind of temperature would you like to see your weather in?\n1 - Celsius\n2 - fahrenheit\n3 - Kelvin");
        String tempPref = scan.nextLine();

        System.out.println("What unit would you like the wind speed in?\n1 - km/h\n2 - m/s\n3 - mph\n4 - Knots");
        String speedUnit = scan.nextLine();

            List<String> errors = Validator.validateInput(countryInit, zipCode);

            if(!errors.isEmpty()){
                System.out.println("Something was incorrect with the data you inputted, please check below for more information: ");
                for (String error: errors){
                    System.out.println(" - " + error + " ");
                }
            } else {

                String[] zipList = ZipToCountry.CountryZipCode(countryInit, zipCode); //Grabs information of country and zip code

                int index = 0;
                for (String s : zipList) { //Prints out information
                    // Conditional statements are wonderful. I enjoy using them for formating
                    String format = (index == 0 ? "Latitude: " + zipList[index] : index == 1 ? "Longitude: " + zipList[index] : index == 2 ? "Country Name: " + zipList[index] : "City Name: " + zipList[index]);
                    System.out.println(format);
                    index++;
                }

                System.out.println("The weather in the format of a list: "); //Grabs information of weather.
                List<String> weatherList = WeatherSettings.weatherChecker(Double.parseDouble(zipList[0]), Double.parseDouble(zipList[1]), tempPref, speedUnit);

                //Hastily put together because I forgot to add the interface AND the class.
               WeatherInterface  day1 = new Weather(weatherList.get(0), weatherList.get(1), weatherList.get(2), weatherList.get(3), weatherList.get(4), weatherList.get(5));
                WeatherInterface day2 = new Weather(weatherList.get(6), weatherList.get(7), weatherList.get(8), weatherList.get(9), weatherList.get(10), weatherList.get(11));
                WeatherInterface day3 = new Weather(weatherList.get(12), weatherList.get(13), weatherList.get(14), weatherList.get(15), weatherList.get(16), weatherList.get(17));
                WeatherInterface day4 = new Weather(weatherList.get(18), weatherList.get(19), weatherList.get(20), weatherList.get(21), weatherList.get(22), weatherList.get(23));
                WeatherInterface day5 = new Weather(weatherList.get(24), weatherList.get(25), weatherList.get(26), weatherList.get(27), weatherList.get(28), weatherList.get(29));
                WeatherInterface day6 = new Weather(weatherList.get(30), weatherList.get(31), weatherList.get(32), weatherList.get(33), weatherList.get(34), weatherList.get(35));
                WeatherInterface day7 = new Weather(weatherList.get(36), weatherList.get(37), weatherList.get(38), weatherList.get(39), weatherList.get(40), weatherList.get(41));

                //Grabs the current day and next six days
                String[] dates;
                dates = SevenDayDatesGrabber.dateFinder();

                index = 1; // resets index to 1
                for (String date : dates){
                    System.out.println(date);

                    switch (index){

                        case 1:
                            day1.weatherData();
                            break;
                        case 2:
                            day2.weatherData();
                            break;
                        case 3:
                            day3.weatherData();
                            break;
                        case 4:
                            day4.weatherData();
                            break;
                        case 5:
                            day5.weatherData();
                            break;
                        case 6:
                            day6.weatherData();
                            break;
                        case 7:
                            day7.weatherData();
                        default:
                            day1.weatherData();
                    }
                    System.out.println("\n");
                    index++;
                }






            }
    }
}
