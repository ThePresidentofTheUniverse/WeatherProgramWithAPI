public class Weather {

    //What is being tracked of will be listed below...
    private String location;
    private String country;
    private String city;
    private double temperature;
    private double windDirection; //10 m
    private double windSpeed; //10 m
    private double rain;
    private double snowFall;
    private double showers;

    //constructor
    public Weather(String location, String country, String city, double temperature, double windDirection, double windSpeed, double rain, double snowFall, double showers) {
        this.location = location;
        this.country = country;
        this.city = city;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.rain = rain;
        this.snowFall = snowFall;
        this.showers = showers;
    }

    //Getters and setters
    public double getShowers() {
        return showers;
    }
    public void setShowers(double showers) {
        this.showers = showers;
    }
    public double getSnowFall() {
        return snowFall;
    }
    public void setSnowFall(double snowFall) {
        this.snowFall = snowFall;
    }
    public double getRain() {
        return rain;
    }
    public void setRain(double rain) {
        this.rain = rain;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
    public double getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Information of weather:\nLocation: " + location + "\nCountry: " + country + "\nCity: " + city + "\nTemperature: " + temperature + "\nWind Direction: " + windDirection +
                "\nWindSpeed: " + windSpeed + "\nRain: " + rain + "\nSnowFall: " + snowFall + "\nShowers: " + showers;
    }
}
