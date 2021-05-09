package classes.aircrafts;

import classes.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    Aircraft(String name, Coordinates coord) {
        super();
        this.coordinates = coord;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getIdCounter() {
        return idCounter;
    }
}