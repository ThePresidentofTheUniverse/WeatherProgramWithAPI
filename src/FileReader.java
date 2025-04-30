import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader { //I feel like having all the information of countries will look weird, so I decided to have it read from a text file.


    public static String ReadCountry(String countryName) throws FileNotFoundException {

        String data = "";
        File findFile = new File("src\\CountryInformation\\" + countryName);
        Scanner readFile = new Scanner(findFile);
        while (readFile.hasNextLine()){
          data = readFile.nextLine();

            System.out.println(data);

        }
        readFile.close();
        return data;
    }
}
