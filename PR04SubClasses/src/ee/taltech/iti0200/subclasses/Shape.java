package ee.taltech.iti0200.subclasses;

import java.util.Optional;

public abstract class Shape {
    public static final int ROUNDING_MODE = 7;

    Category category;
    double size;
    int number;

    public enum Category {
        BIG("Big"),
        MEDIUM("Medium"),
        SMALL("Small");

        private String sizeName;

        Category(String sizeName) {
            this.sizeName = sizeName;
        }

        public String getSizeName() {
            return sizeName;
        }

    }

    public Shape(Category category, double size) {
        this.category = category;
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public abstract String draw();

    public abstract double calculateArea();

    public Optional<Integer> getNumber() {
        if (this.number > 0) {
            Integer result = number;
            return Optional.of(result);
        }
        return Optional.empty();
    }

    public void putNumber(int number) {
        this.number = number;
    }

    public void clearNumber() {
        this.number = 0;
    }
}

