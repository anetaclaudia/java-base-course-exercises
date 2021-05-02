package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RegularWashTest {

    RegularWash regularWash;
    CarOwner siim;
    CarOwner tauno;
    Car audi;
    Car bmw;

    @BeforeEach
    void setUp() {
        regularWash = new RegularWash();
        siim = new CarOwner("Siim", 1500);
        tauno = new CarOwner("Tauno", 1200);
        audi = new Car(5);
        bmw = new Car(45);
    }

    @Test
    void wash_andDirtinessIs0() {
        regularWash.wash(audi, tauno);
        assert audi.getDirtiness() == 0;
    }

    @Test
    void dry() {
        regularWash.dry(audi, tauno);
        assert regularWash.getSessionDuration() == 20;
    }

    @Test
    void getWashAndDryPrice() {
        assert regularWash.getWashAndDryPrice() == 35;
    }

    @Test
    void getWashPrice() {
        assert regularWash.getWashPrice() == 30;
    }
}
