package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CheapWashTest {
    CheapWash cheapWash;
    CarOwner siim;
    CarOwner tauno;
    Car audi;
    Car bmw;

    @BeforeEach
    void setUp() {
        cheapWash = new CheapWash();
        siim = new CarOwner("Siim", 1500);
        tauno = new CarOwner("Tauno", 1200);
        audi = new Car(5);
        bmw = new Car(45);
    }

    @Test
    void wash_andDirtinessIs0() {
        cheapWash.wash(audi, tauno);
        assert audi.getDirtiness() == 0;
    }

    @Test
    void dry() {
        cheapWash.dry(audi, tauno);
        assert cheapWash.getSessionDuration() == 11;
    }

    @Test
    void getWashAndDryPrice() {
        assert cheapWash.getWashAndDryPrice() == 12;
    }

    @Test
    void getWashPrice() {
        assert cheapWash.getWashPrice() == 10;
    }
}
