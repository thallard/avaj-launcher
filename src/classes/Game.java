package classes;

import java.util.ArrayList;
import classes.aircrafts.*;

public class Game {
    long countLoops;
    ArrayList<Flyabe> aircrafts;

    public Game() {
        aircrafts = new ArrayList<Flyabe>();
    }

    public boolean startSimulation()
    {

        return (true);
    }

    // Setters
    public void setCountLoop(long val) {
        countLoops = val;
    }

    // Getters
    public ArrayList<Flyabe> getAircrafts() {
        return aircrafts;
    }

    public long getCountLoops() {
        return countLoops;
    }

    public void addAircraft(Flyabe aircraft) {
        aircrafts.add(aircraft);
    }
}
