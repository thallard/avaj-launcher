package classes.aircrafts;

import classes.Coordinates;

public class AircraftFactory {
    public static int current_id = 1;

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coord = new Coordinates(latitude, longitude, height);
       
        switch (type) {
            case "Helicopter":
                return new Helicopter(current_id++, name, coord);
            case "Baloon":
                return new Baloon(current_id++, name, coord);
            case "JetPlane":
                return new JetPlane(current_id++, name, coord);
            default:
                return null;
        }

    }
}
