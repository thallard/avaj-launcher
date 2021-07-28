package classes.aircrafts;

import classes.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    Aircraft(int id, String name, Coordinates coord) {
        super();
        this.id = id;
        this.coordinates = coord;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public long getIdCounter() {
        return idCounter;
    }



}