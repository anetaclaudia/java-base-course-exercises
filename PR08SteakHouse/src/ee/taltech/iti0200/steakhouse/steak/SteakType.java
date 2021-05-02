package ee.taltech.iti0200.steakhouse.steak;

public enum SteakType {
    FILET_MIGNON(150),

    RIB_EYE_STEAK(300),

    NEW_YORK_STRIP(350);

    private final int mass; // in grams

    SteakType(int mass) {
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }
}
