package classes.aircrafts;

import classes.*;
import classes.weather.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(int id, String name, Coordinates coord) {
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
        Coordinates jetCoord = this.getCoordinates();
        if (jetCoord.getHeight() <= 0)
        {
            weatherTower.unregister(this);
            return ;
        }
        switch (weatherTower.getWeather(coord)) {
            case "SUN":
                System.out.println("\033[0;33m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): What a sun today!\033[0m");
                jetCoord.setLatitude(this.getLatitude() + 10);
                jetCoord.setHeight(this.getHeight() + 2);
                break;
            case "SNOW":
                System.out.println(getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): OMG! Winter is coming!");
                jetCoord.setHeight(this.getHeight() - 7);
                break;
            case "RAIN":
                System.out.println("\033[34m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): It's raining. Better watch out for lightings.\033[0m");
                jetCoord.setLatitude(this.getLatitude() + 5);
                break;
            case "FOG":
                System.out.println("\033[94m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Let's upgrade our latitude to avoid fog!\033[0m");
                jetCoord.setLatitude(this.getLatitude() + 1);
                break;
            default:
                break;
        }
        if (jetCoord.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;


    }
}
