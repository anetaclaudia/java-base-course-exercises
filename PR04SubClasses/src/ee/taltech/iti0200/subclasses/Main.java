package ee.taltech.iti0200.subclasses;

public class Main {

    public static void main(String[] args) {
        Shape square = new Square(Shape.Category.BIG, 10);
        Shape circle = new Circle(Shape.Category.SMALL, 2);

        System.out.println(square.draw()); // Drawing square! Category: Big
        System.out.println(circle.draw()); // Drawing circle! Category: Small

        circle.setCategory(Shape.Category.MEDIUM);
        System.out.println(circle.draw()); // Drawing circle! Category: Medium

        System.out.println(circle.calculateArea()); // 12.566370614359172
        System.out.println(square.calculateArea()); // 100.0

//        circle.setSize(3);
//        System.out.println(circle.calculateArea());
//        square.setSize(5); // 25.0000000
//        System.out.println(square.calculateArea());

        circle.setSize(1);
        System.out.println(circle.calculateArea());
        System.out.println(Math.PI);

//        circle.putNumber(6);
//        System.out.println(square.getNumber()); // Optional.empty()
//        System.out.println(circle.getNumber().isPresent()); // true
//        System.out.println(circle.getNumber().get()); // 6
//        circle.clearNumber();
//        System.out.println(circle.getNumber());  // Optional.empty()
    }
}
