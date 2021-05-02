package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CarTest {
    Car audi;

    @BeforeEach
    void setUp() {
        audi = new Car(5);
    }

    @Test
    void setDirtiness() {
        audi.setDirtiness(10);
        assert audi.getDirtiness() == 10;
    }

    @Test
    void getDirtiness() {
        assert audi.getDirtiness() == 5;
    }
}
