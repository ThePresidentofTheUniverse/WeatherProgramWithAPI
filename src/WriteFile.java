import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void main(String[] args) {
        String[] test = new String[3];
        test[0] = "test";
    test[1] = "test";
        test[2] = "test";
        FileWrites(test);

    }

    public static boolean FileWrites(String[] savedConfigs){
        boolean isSuccessful;
        try{
            FileWriter writer = new FileWriter("SavedConfig.txt");
            for (String config : savedConfigs){
                writer.write(config);
                writer.write("|");
            }
            writer.close();
            isSuccessful = true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isSuccessful;
    }
}
