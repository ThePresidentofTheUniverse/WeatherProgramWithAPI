import java.util.ArrayList;
import java.util.List;


public class Validator {

    public static List<String> validateInput(String countryInit, String zipCode){
        List<String> errors = new ArrayList<>();
        if(!isValidCountryInitials(countryInit)){
            errors.add("The country initials are not valid, please check input.");
        }
        if(!isValidZipCode(zipCode, countryInit)){
            errors.add("The zip code you have entered is not valid, please check input");
        }

        return errors; //This returns all errors.
    }

    //Country Initials validation
    private static boolean isValidCountryInitials(String countryInit){
        return countryInit != null && !countryInit.trim().isEmpty();
    }

    //Zip code validation (I built a separate method for this validation).
    private static boolean isValidZipCode(String zipCode, String countryInit){
       return zipCode != null && RegexForZipCodes.CountryRegex(zipCode, countryInit);


    }

}
