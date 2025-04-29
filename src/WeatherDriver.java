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

            List<String> errors = Validator.validateInput(countryInit, zipCode);

            if(!errors.isEmpty()){
                System.out.println("Something was incorrect with the data you inputted, please check below for more information: ");
                for (String error: errors){
                    System.out.println(" - " + error + " ");
                }
            } else {

                String[] zipList = ZipToCountry.CountryZipCode(countryInit, zipCode);


                int index = 0;
                for (String s : zipList) {
                    // Conditional statements are wonderful. I enjoy using them for formating
                    String format = (index == 0 ? "Latitude: " + zipList[index] : index == 1 ? "Longitude: " + zipList[index] : index == 2 ? "Country Name: " + zipList[index] : "City Name: " + zipList[index]);
                    System.out.println(format);
                    index++;
                }

                System.out.println("The weather in the format of a list: ");
                List<String> weatherList = WeatherSettings.weatherChecker(Double.parseDouble(zipList[0]), Double.parseDouble(zipList[1]), tempPref);

                System.out.println(weatherList);
            }
    }
}
