import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    // All fields from the form below
    public Label Country;
    public ComboBox<String> cmbCountry;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCountry.setItems(FXCollections.observableArrayList("Andorra","Argentina","American Samoa", "Austria", "Australia", "Bangladesh", "Belgium", "Belgium", "Bulgaria", "Brazil", "Canada", "Switzerland"));
    }
}
