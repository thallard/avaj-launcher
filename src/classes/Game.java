package classes;

import java.util.ArrayList;
import classes.aircrafts.*;

public class Game {
    long countLoops;
    ArrayList<Flyabe> aircrafts;

    public Game()
    {
        aircrafts = new ArrayList<Flyabe>();
    }

    // Setters
    public void setCountLoop(long val) { countLoops = val; }

    // Getters
    public ArrayList<Flyabe> getAircrafts() { return aircrafts; }

    public void addAircraft(Flyabe aircraft) { aircrafts.add(aircraft); }
}
