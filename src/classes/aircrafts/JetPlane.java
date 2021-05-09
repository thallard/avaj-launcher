package classes.aircrafts;
import classes.Coordinates;

public class JetPlane extends Aircraft implements Flyabe {
      // private WeatherTower weatherTower;

      public JetPlane(String name, Coordinates coord)
      {
          super(name, coord);
      }
  
      public void updateConditions()
      {
  
      }
  
      // public void registerTower(Weathertower weathertower)
}
