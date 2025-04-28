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
        String countryInit = scan.nextLine();
        System.out.print("Please enter the desired zip code: ");
        String zipCode = scan.nextLine();

        String[] zipList = ZipToCountry.CountryZipCode(countryInit, zipCode);

        int index = 0;
        for (String s : zipList){
            System.out.println(zipList[index]);
            index++;
        }

    }
}
