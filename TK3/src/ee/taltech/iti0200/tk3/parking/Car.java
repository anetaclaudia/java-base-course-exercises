package ee.taltech.iti0200.tk3.parking;

public class Car {
    String model;
    int size;

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }

    public Car(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", model, size);
    }
}
