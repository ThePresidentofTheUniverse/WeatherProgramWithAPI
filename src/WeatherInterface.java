// This is being added... for reasons
public interface WeatherInterface {

    //Stuff that all weather has
    String getTemp();
    String getWindDirection();
    String getWindSpeed();
    String getRain();
    String getSnowFall();
    String getShowers();

    //Declaring an abstract method
    void weatherData();

}
