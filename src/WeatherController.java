import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    // All fields from the form below
    public Label lblCountry;
    public ComboBox<String> cmbCountry;
    public Label lblZipCode;
    public TextField txtZipCode;
    public Label lblTempUnit;
    public ComboBox<String> cmbTempUnit;
    public Label lblWindSpeed;
    public ComboBox<String> cmbWindSpeed;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCountry.setItems(FXCollections.observableArrayList("Andorra","Argentina","American Samoa", "Austria", "Australia", "Bangladesh", "Belgium", "Belgium", "Bulgaria", "Brazil", "Canada", "Switzerland"));
        cmbTempUnit.setItems(FXCollections.observableArrayList("Celsius", "Fahrenheit", "Kelvin"));
        cmbWindSpeed.setItems(FXCollections.observableArrayList("km/h", "m/s", "mph", "Knots"));
    }


}
