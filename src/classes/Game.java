package classes;

import classes.aircrafts.*;
import classes.weather.*;

public class Game {
    public long countLoops;
    public WeatherTower weatherTower;

    public Game() {
        weatherTower = new WeatherTower();
    }

    // Setters
    public void setCountLoop(long val) { countLoops = val; }

    // Getters
    public WeatherTower getWeatherTower() { return weatherTower; }
    public long getCountLoops() { return countLoops; }


    public void addAircraft(Flyable aircraft) {
        weatherTower.register(aircraft);
        String className = aircraft.getClass().getSimpleName();
        switch (className) {
            case "Baloon":
                ((Baloon) aircraft).registerTower(this.weatherTower);
                break;
            case "Helicopter":
                ((Helicopter) aircraft).registerTower(this.weatherTower);
                break;
            case "JetPlane":
                ((JetPlane) aircraft).registerTower(this.weatherTower);
            default:
                break;
        }
    }
}
