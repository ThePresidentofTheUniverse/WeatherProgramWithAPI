import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//This loads the main application.
public class WeatherApplication extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("WeatherForm.fxml"));
        stage.setResizable(false);
        stage.setTitle("Your world-wide Weather Checker");
        stage.getIcons().add(new Image("Images/CloudIcon.png"));
        stage.setScene(new Scene(root, 800, 445));
        stage.show();
    }
}
