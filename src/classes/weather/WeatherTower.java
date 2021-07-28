package classes.weather;

import classes.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates)
    {
        super.conditionsChanged();
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    // Unused
    private void changeWeather() {

    }
}
