import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
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
    public Label lblError;
    public Label lblError1;
    public Label lblError2;
    public Label lblError3;

    //Adds information to the combo boxes, perfect for controlling user input
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCountry.setItems(FXCollections.observableArrayList("Andorra (AD)","Argentina (AR)","American Samoa (AS)", "Austria (AT)", "Australia (AU)", "Bangladesh (BD)", "Belgium (BE)", "Bulgaria (BG)", "Brazil (BR)", "Canada (CA)", "Switzerland (CH)", "United States (US)"));
        cmbTempUnit.setItems(FXCollections.observableArrayList("Celsius", "Fahrenheit", "Kelvin"));
        cmbWindSpeed.setItems(FXCollections.observableArrayList("km/h", "m/s", "mph", "Knots"));
    }

     //A method to add information to the array list.
    public ObservableList<Weather> getWeather(List<String> weatherList){

        ObservableList<Weather> weather = FXCollections.observableArrayList();

        String[] dates;
        //Grabs the current day and next six days
        dates = SevenDayDatesGrabber.dateFinder();

//            //Adds the weather to the table
            weather.add(new Weather(weatherList.get(0), weatherList.get(1), weatherList.get(2), weatherList.get(3), weatherList.get(4), weatherList.get(5), dates[0]));
            weather.add(new Weather(weatherList.get(6), weatherList.get(7), weatherList.get(8), weatherList.get(9), weatherList.get(10), weatherList.get(11), dates[1]));
            weather.add(new Weather(weatherList.get(12), weatherList.get(13), weatherList.get(14), weatherList.get(15), weatherList.get(16), weatherList.get(17), dates[2]));
            weather.add(new Weather(weatherList.get(18), weatherList.get(19), weatherList.get(20), weatherList.get(21), weatherList.get(22), weatherList.get(23), dates[3]));
            weather.add(new Weather(weatherList.get(24), weatherList.get(25), weatherList.get(26), weatherList.get(27), weatherList.get(28), weatherList.get(29), dates[4]));
            weather.add(new Weather(weatherList.get(30), weatherList.get(31), weatherList.get(32), weatherList.get(33), weatherList.get(34), weatherList.get(35), dates[5]));
            weather.add(new Weather(weatherList.get(36), weatherList.get(37), weatherList.get(38), weatherList.get(39), weatherList.get(40), weatherList.get(41), dates[6]));

        return weather;
    }

    //The button that checks the weather.
    @FXML
    void checkingWeather(){
        try{
            //Sets the default values if left empty.
            String tempUnit = "Celsius";
            String windSpeed = "km/h";
            String country = "";
            String zipCode;

            //Grabs the new values inputted & Checks to see if the values are null or not
            if (cmbCountry.getValue() != null){
                country = nameRemover(cmbCountry.getValue());
            }
            zipCode = txtZipCode.getText().trim();
            if (cmbTempUnit.getValue() != null) {
                tempUnit = cmbTempUnit.getValue();
            }
            if (cmbWindSpeed.getValue() != null) {
                windSpeed = cmbWindSpeed.getValue();
            }


            System.out.println(country);
            //Validates user input
            int errorCount = 1;
            List<String> errors = Validator.validateInput(country, zipCode); //This exists early on so errors can be added to it.
            if (!errors.isEmpty()){ //Outputs error to both the console and the program, allowing users to understand that the information is not valid.
                System.out.println("Something was incorrect with the data you inputted, please check below for more information: ");

                for (String error: errors){
                    System.out.println(error);
                    lblError.setText("An error has occurred,please check\nlist below for more information:");
                    switch (errorCount){

                        case 1:
                            lblError1.setText(error);
                            break;
                        case 2:
                            lblError2.setText(error);
                            break;
                        case 3:
                            lblError3.setText(error);
                            break;
                    }
                    errorCount++;
                }



            } else { //Grabs data and sends it out.
                String[] zipList = ZipToCountry.CountryZipCode(country, zipCode);
                //Grabs the current day and next six days
                String[] dates;
                dates = SevenDayDatesGrabber.dateFinder();

                List<String> weatherList = WeatherSettings.weatherChecker(Double.parseDouble(zipList[0]), Double.parseDouble(zipList[1]), tempUnit, windSpeed);
                WeatherInterface today = new Weather(weatherList.get(0), weatherList.get(1), weatherList.get(2), weatherList.get(3), weatherList.get(4), weatherList.get(5), dates[1]);

                // Makes sure that information is out putted correctly.
                today.weatherData();

                //Allows columns to function in the table, they must have the same names as the getters.
                colInformation.setCellValueFactory(new PropertyValueFactory<Weather, String>("Date"));
                colDay1.setCellValueFactory(new PropertyValueFactory<Weather, String>("Temp"));
                colDay2.setCellValueFactory(new PropertyValueFactory<Weather, String>("WindDirection"));
                colDay3.setCellValueFactory(new PropertyValueFactory<Weather, String>("WindSpeed"));
                colDay4.setCellValueFactory(new PropertyValueFactory<Weather, String>("Rain"));
                colDay5.setCellValueFactory(new PropertyValueFactory<Weather, String>("SnowFall"));
                colDay6.setCellValueFactory(new PropertyValueFactory<Weather, String>("Showers"));


                tblWeeklyWeather.setItems(getWeather(weatherList)); //Adds information of weather

                //Adds information of location to labels.

               lblError.setText(""); //Clears any previous errors shown.
               lblError1.setText("");
               lblError2.setText("");
               lblError3.setText("");
            }
        } catch (Exception e){ //A catch-all to make sure that there are no errors that I missed.
            System.out.println(e);

        }
    }

    //Method that removes the non-parenthesis from country string.
    public static String nameRemover(String input){

        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile("\\([A-Z]{2}\\)"); //God, I love regex.
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

        return result.toString();
    }


}
