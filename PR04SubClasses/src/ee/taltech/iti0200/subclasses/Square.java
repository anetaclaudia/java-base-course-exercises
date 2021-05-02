package ee.taltech.iti0200.subclasses;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square extends Shape {

    Square(Category category, double size) {
        super(category, size);
    }

    @Override
    public String draw() {
        return String.format("Drawing square! Category: %s", super.getCategory().getSizeName());
    }

    @Override
    public double calculateArea() {
        BigDecimal result = BigDecimal.valueOf(getSize() * getSize())
                .setScale(ROUNDING_MODE, RoundingMode.FLOOR);
        return result.doubleValue();
    }
}
