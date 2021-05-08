package classes.aircrafts;

public class Aircraft {
    protected long id;
    protected String name;
    // Coordinates
    private long idCounter;

    Aircraft(long id, String name, long idCounter) {
        super();
        this.id = id;
        this.name = name;
        this.idCounter = idCounter;
    }
}