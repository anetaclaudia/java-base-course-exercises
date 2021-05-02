package ee.taltech.iti0200.singleton;

public class Unicorn {
    private double hornLength;
    private String color;
    private String location;
    private Size size;

    enum Size {
        TINY,
        SMALL,
        MEDIUM,
        LARGE
    }

    public Unicorn(double hornLength, String color, String location, Size size) {
        this.hornLength = hornLength;
        this.color = color;
        this.location = location;
        this.size = size;
    }

    public double getHornLength() {
        return hornLength;
    }

    public String getColor() {
        return color;
    }

    public String getLocation() {
        return location;
    }

    public Size getSize() {
        return size;
    }
}
