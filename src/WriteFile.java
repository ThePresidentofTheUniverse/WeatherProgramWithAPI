import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static boolean FileWrites(String[] savedConfigs){ //Used to write information to a file.
        boolean isSuccessful;
        try{
            FileWriter writer = new FileWriter("SavedConfig");
            for (String config : savedConfigs){
                writer.write(config);
                writer.write("|");
            }
            writer.close();
            isSuccessful = true;
            System.out.println("Success");

        } catch (IOException e) {
            System.out.println("Failed");
            throw new RuntimeException(e);

        }
        return isSuccessful;
    }
}
