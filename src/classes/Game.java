package classes;

import java.util.ArrayList;
import classes.aircrafts.*;
import classes.weather.*;

public class Game {
    public long countLoops;
    public ArrayList<Flyable> aircrafts;
    public static Tower tower = new Tower();
    public WeatherTower weatherTower;

    public Game() {
        System.out.println("ici");
        aircrafts = new ArrayList<Flyable>();
        weatherTower = new WeatherTower();
    }

    // Setters
    public void setCountLoop(long val) { countLoops = val; }

    // Getters
    public ArrayList<Flyable> getAircrafts() { return aircrafts; }
    public WeatherTower getWeatherTower() { return weatherTower; }
    public long getCountLoops() { return countLoops; }


    public void addAircraft(Flyable aircraft) {
        aircrafts.add(aircraft);
        tower.register(aircraft);
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
