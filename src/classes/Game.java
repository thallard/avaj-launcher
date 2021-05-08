package classes;

import java.util.ArrayList;

import classes.aircrafts.Aircraft;

public class Game {
    long countLoops;
    ArrayList<Aircraft> aircrafts;

    public Game()
    {
        aircrafts = new ArrayList<Aircraft>();
    }

    public void setCountLoop(long val) { countLoops = val; }
}
