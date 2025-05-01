import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigFileReader {
    public static String ReadConfig() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        String data = "";
        File findFile = new File("src\\SavedConfig");
        Scanner readFile = new Scanner(findFile);
        while (readFile.hasNextLine()){
            data = readFile.nextLine();
            sb.append("\n"+data);
        }
        System.out.println(sb);
        readFile.close();

        return sb.toString();
    }
}
