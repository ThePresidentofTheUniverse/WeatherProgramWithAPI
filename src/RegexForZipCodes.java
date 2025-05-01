import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexForZipCodes {

    //PLEASE NOTE: Unfortunately, without access to massive databases, there is no 100% to check the validity of a zipcode.
    //These regexes are used to make sure that the formatting is correct, at least.
    public static boolean CountryRegex(String zipCode, String countryInit){

        boolean matchfound = false;

        switch (countryInit.toUpperCase()){

            case "US":
                Pattern patternUSA = Pattern.compile("^[0-9]{5}(-[0-9]{4})?$"); //Regex for USA (Found on the inter-web)
                Matcher matcher1 = patternUSA.matcher(zipCode);
                boolean correct1 = matcher1.find();
                if (correct1){
                    matchfound = true;
                }
                break;
            case "AD":
                Pattern patternAndorra = Pattern.compile("^AD(100|200|300|400|500|600|700)$"); //Regex for Andorra (made by me)
                Matcher matcher2 = patternAndorra.matcher(zipCode);
                boolean correct2 = matcher2.find();
                if (correct2){
                    matchfound = true;
                }
                break;
            case "AS":
                Pattern patternAmericanSamoa = Pattern.compile("^96799$"); //There is literal one code.
                Matcher matcher3 = patternAmericanSamoa.matcher(zipCode);
                boolean correct3 = matcher3.find();
                if (correct3){
                    matchfound = true;
                }
                break;
            case "BR":
                Pattern patternBrazil = Pattern.compile("^\\d{5}-(000)$"); //Regex for Brazil (by me).
                Matcher matcher4 = patternBrazil.matcher(zipCode);
                boolean correct4 = matcher4.find();
                if (correct4){
                    matchfound = true;
                }
                break;
            case "CA":
                Pattern patternCanada = Pattern.compile("^[A-Y]\\d[A-Z]$"); //Canadian Regex (by me).
                Matcher matcher5 = patternCanada.matcher(zipCode);
                boolean correct5 = matcher5.find();
                if (correct5){
                    matchfound = true;
                }
                break;
            case "CZ":
                Pattern patternCzech = Pattern.compile("^[0-9]{3}\\s[0-9]{2}$");
                Matcher matcher7 = patternCzech.matcher(zipCode);
                boolean correct7 = matcher7.find();
                if (correct7){
                    matchfound = true;
                }
            case "DE", "DO", "ES", "FI": //Multiple countries use 5 letter zip codes
                Pattern patternFiveNumber = Pattern.compile("^[0-9]{5}$");
                Matcher matcher8 = patternFiveNumber.matcher(zipCode);
                boolean correct8 = matcher8.find();
                if(correct8){
                    matchfound = true;
                }
            case "FO":
                Pattern patternFaroe = Pattern.compile("^[0-9]{3}$");
                Matcher matcher9 = patternFaroe.matcher(zipCode);
                boolean correct9 = matcher9.find();
                if(correct9){
                    matchfound = true;
                }
            default:
                Pattern patternMultiple = Pattern.compile("^\\d{4}$");
                Matcher matcher6 = patternMultiple.matcher(zipCode);
                boolean correct6 = matcher6.find();
                if (correct6){
                    matchfound = true;
                }
                break;
                //Semi-effective postal code for Multiple Countries shown below (made by me)
                /*Works with:
                 * Argentina
                 * Austria
                 * Australia
                 * Bangladesh
                 * Belgium
                 * Bulgaria
                 * Switzerland
                 * Denmark
                 * GreenLand
                 * Hungary
                 */
        }
        //Stopped at Czech Republic

        return matchfound;
    }
}
