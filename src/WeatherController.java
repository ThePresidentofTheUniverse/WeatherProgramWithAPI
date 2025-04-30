import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Button btnCheckWeather;
    public TableView<Weather> tblWeeklyWeather;
    public TableColumn<Weather, String> colInformation;
    public TableColumn<Weather, String> colDay1;
    public TableColumn<Weather, String> colDay2;
    public TableColumn<Weather, String> colDay3;
    public TableColumn<Weather, String> colDay4;
    public TableColumn<Weather, String> colDay5;
    public TableColumn<Weather, String> colDay6;
    public TableColumn<Weather, String> colDay7;

    //Adds information to the combo boxes, perfect for controlling user input
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCountry.setItems(FXCollections.observableArrayList("Andorra (AD)","Argentina (AR)","American Samoa (AS)", "Austria (AT)", "Australia (AU)", "Bangladesh (BD)", "Belgium (BE)", "Bulgaria (BG)", "Brazil (BR)", "Canada (CA)", "Switzerland (CH)", "United States (US)"));
        cmbTempUnit.setItems(FXCollections.observableArrayList("Celsius", "Fahrenheit", "Kelvin"));
        cmbWindSpeed.setItems(FXCollections.observableArrayList("km/h", "m/s", "mph", "Knots"));

        //Allows columns to function in the table
        colInformation.setCellValueFactory(new PropertyValueFactory<Weather, String>("Information"));
        colDay1.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 1"));
        colDay2.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 2"));
        colDay3.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 3"));
        colDay4.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 4"));
        colDay5.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 5"));
        colDay6.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 6"));
        colDay7.setCellValueFactory(new PropertyValueFactory<Weather, String>("Day 7"));

      //  tblWeeklyWeather.setItems();
    }

    // A method to add information to the array list.
//    public ObservableList<Weather> getWeather(){
//
//        ObservableList<Weather> weather = FXCollections.observableArrayList();
//
//        for ()
//        weather.add(new Weather());
//    }



    //The button that checks the weather.
    @FXML
    void checkingWeather(){
        try{
            String country = nameRemover(cmbCountry.getValue());
            String zipCode = txtZipCode.getText().trim();
            String TempUnit = cmbTempUnit.getValue();
            String windSpeed = cmbWindSpeed.getValue();

            System.out.println(country);
            //Validates user input
            Validator.validateInput(country, zipCode);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //Method that removes the non-parenthesis from country string.
    public static String nameRemover(String input){

        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile("\\([A-Z]{2}\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            if(match.startsWith("("))  {
                result.append(match);
            }
        }
        // Deletes the left-over parenthesis
        result.deleteCharAt(3);
        result.deleteCharAt(0);
        String baseChars = result.toString();

        return baseChars;
    }


}
