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

    public void setLatitude(int latitude) { this.latitude = latitude; }
    public void setLongitude(int longitude) { this.longitude = longitude; }

    public void setHeight(int height) {
        if (height > 0 && height + this.height > 100)
        this.height = 100;
    else
        this.height = height;
    }
}
