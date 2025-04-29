import java.util.ArrayList;
import java.util.List;


public class Validator {

    public static List<String> validateInput(){
        List<String> errors = new ArrayList<>();


        return errors;
    }

    //Country Initials validation
    private static boolean isValidCountryInitials(String countryInit){
        return countryInit != null && countryInit.trim().isEmpty() && countryInit.length() == 2;
    }

    //Zip code validation
    private static boolean isValidZipCode(String zipCode){

        if (zipCode != ){

        }
    }

}
