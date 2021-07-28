package classes.aircrafts;

import classes.*;
import classes.weather.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(int id, String name, Coordinates coord) {
        super(id, name, coord);
    }

    public int getLatitude() {
        return coordinates.getLatitude();
    }

    public int getHeight() {
        return coordinates.getHeight();
    }

    public int getLongitude() {
        return coordinates.getLongitude();
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void updateConditions()
    {
        Coordinates coord = new Coordinates(this.getLatitude(), this.getLongitude(), this.getHeight());
        Coordinates baloonCord = this.getCoordinates();

        switch (weatherTower.getWeather(coord)) {
            case "SUN":
                System.out.println("\033[0;33m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): This is hot.\033[0m");
                baloonCord.setLongitude(this.getLongitude() + 10);
                baloonCord.setHeight(this.getHeight() + 2);
                break;
            case "SNOW":
                System.out.println(getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): My rotor is going to freeze!");
                baloonCord.setHeight(this.getHeight() - 12);
                break;
            case "RAIN":
                System.out.println("\033[34m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): It's raining. Let's close our windows!\033[0m");
                baloonCord.setLongitude(this.getLongitude() + 5);
                break;
            case "FOG":
                System.out.println("\033[94m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): I don't see anything, help!\033[0m");
                baloonCord.setLongitude(this.getLongitude() + 1);
                break;
            default:
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        System.out.println("\033[0;32mTower says: " + getClass().getSimpleName() + "#" + getName() + "(" + getId() + ") registered to weather tower.\033[0;0m");

    }
}




