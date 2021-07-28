package classes.weather;

import classes.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = new String[] { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int random = (int)(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + (Math.random() * 3)) % 10;
        if (random >= 0 && random < 3)
            return "SNOW";
        else if (random >= 3 && random < 5)
            return "FOG";
        else if (random >= 5 && random < 8)
            return "SUN";
        else
            return "RAIN";
    }
}
