package classes.aircrafts;

import classes.Coordinates;

public class AircraftFactory {
    public Flyabe newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coord = new Coordinates(latitude, longitude, height);
       
        switch (type) {
            case "Helicopter":
                Helicopter helicopter = new Helicopter(name, coord);
                return helicopter;
            case "Baloon":
                Baloon baloon = new Baloon(name, coord);
                return baloon;
            case "JetPlane":
                JetPlane jetplane = new JetPlane(name, coord);
                return jetplane;
            default:
                return null;
        }

    }
}
