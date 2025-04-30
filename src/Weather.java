public class Weather implements WeatherInterface {

    //What is being tracked of will be listed below...
    private String date;
    private String temperature;
    private String windDirection;
    private String windSpeed;
    private String rain;
    private String snowFall;
    private String showers;

    //constructor
    public Weather(String temperature, String windDirection, String windSpeed, String rain, String snowFall, String showers, String date) {
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.rain = rain;
        this.snowFall = snowFall;
        this.showers = showers;
        this.date = date;
    }

    //Getters and setters
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String getTemp() {
        return temperature;
    }

    @Override
    public String getWindDirection() {
        return windDirection;
    }

    @Override
    public String getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String getRain() {
        return rain;
    }

    @Override
    public String getSnowFall() {
        return snowFall;
    }

    @Override
    public String getShowers() {
        return showers;
    }

    @Override
    public void weatherData() {
        System.out.println("Information of weather:\nDate: " + date + "\nTemperature: " + temperature + "\nWind Direction: " + windDirection +
                "\nWindSpeed: " + windSpeed + "\nRain: " + rain + "\nSnowFall: " + snowFall + "\nShowers: " + showers);
    }
}
