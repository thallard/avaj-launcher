package classes.aircrafts;

public interface Flyable
{
    public abstract void updateConditions();
    public abstract long getId();
    public abstract String getName();
    public abstract String getType();
    public abstract int getLatitude();
    public abstract int getHeight();
    public abstract int getLongitude();
}