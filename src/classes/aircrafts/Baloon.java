package classes.aircrafts;

import classes.Coordinates;

public class Baloon extends Aircraft implements Flyabe {
    // private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coord)
    {
        super(name, coord);
    }

    public void updateConditions()
    {

    }

    public String getName() { return name; }

    // public void registerTower(Weathertower weathertower)
    
}
