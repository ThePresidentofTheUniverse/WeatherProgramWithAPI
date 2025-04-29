import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexForZipCodes {

    public static void main(String[] args) {

    }

    //PLEASE NOTE: Unfortunately, without access to massive databases, there is no 100% to check the validity of a zipcode.
    //These regexes are used to make sure that the formatting is correct, at least.
    public static void CountryRegex(String zipCode){
        Pattern patternUSA = Pattern.compile("^[0-9]{5}(-[0-9]{4})?$"); //Regex for USA (Found on the inter-web)
        Pattern patternAndorra = Pattern.compile("^AD(100|200|300|400|500|600|700)$"); //Regex for Andorra (made by me)
        Pattern patternMultiple = Pattern.compile("^\\d{4}$"); //Semi-effective postal code for Multiple Countries shown below (made by me)
        /*Works with:
        * Argentina
        * Austria
        * Australia
        * Bangladesh
        * Belgium
        * Bulgaria
         */
        Pattern patternAmericanSamoa = Pattern.compile("^96799$"); //There is literal one code.
        Pattern patternBrazil = Pattern.compile("^\\d{9}-(000)$"); //Regex for Brazil (by me).
        Pattern patternCanada = Pattern.compile("^[A-Y]\\d[A-Z]$"); //Canadian Regex (by me).

    }
}
