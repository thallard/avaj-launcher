package classes.aircrafts;

import classes.Coordinates;
import classes.weather.*;
import javafx.scene.layout.CornerRadii;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(int id, String name, Coordinates coord) {
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

    public void updateConditions() {
        Coordinates coord = new Coordinates(this.getLatitude(), this.getLongitude(), this.getHeight());
        Coordinates baloonCord = this.getCoordinates();

        switch (weatherTower.getWeather(coord)) {
            case "SUN":
                System.out.println("\033[0;33m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Let's enjoy the good weather and take some pics.\033[0m");
                baloonCord.setLongitude(this.getLongitude() + 2);
                baloonCord.setHeight(this.getHeight() + 4);
                break;
            case "SNOW":
                System.out.println(getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): It's snowing. We're gonna crash.");
                baloonCord.setHeight(this.getHeight() - 15);
                break;
            case "RAIN":
                System.out.println("\033[34m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Damn you rain! You messed up my baloon.\033[0m");
                baloonCord.setHeight(this.getHeight() - 5);
                break;
            case "FOG":
                System.out.println("\033[94m" + getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): I can't see anything!\033[0m");
                baloonCord.setHeight(this.getHeight() - 3);
                break;
            default:
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
    
}
