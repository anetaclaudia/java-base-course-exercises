package ee.taltech.iti0200.subclasses;

public class Circle extends Shape {

    Circle(Category category, double size) {
        super(category, size);
    }

    @Override
    public String draw() {
        return String.format("Drawing circle! Category: %s", super.getCategory().getSizeName());
    }

    @Override
    public double calculateArea() {
        return Math.PI * getSize() * getSize();
    }
}
