package classes;

public class Coordinates {
    public int latitude;
    public int longitude;
    public int height;

    public Coordinates(int lat, int longi, int h)
    {
        latitude = lat;
        longitude = longi;
        height = h;
    }

    public int getLatitude() { return latitude; }
    public int getLongitude() { return longitude; }
    public int getHeight() { return height; }
}
