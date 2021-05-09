package classes.aircrafts;

import classes.Coordinates;

public class AircraftFactory {
    Flyabe newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coord = new Coordinates(latitude, longitude, height);
        Helicopter oui = new Helicopter(name, coord);
        // oui.height = 1;

        return oui;
    }
}
