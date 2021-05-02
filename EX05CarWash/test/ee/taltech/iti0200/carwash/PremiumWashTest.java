package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PremiumWashTest {

    PremiumWash premiumWash;
    CarOwner siim;
    CarOwner tauno;
    Car audi;
    Car bmw;

    @BeforeEach
    void setUp() {
        premiumWash = new PremiumWash();
        siim = new CarOwner("Siim", 1500);
        tauno = new CarOwner("Tauno", 1200);
        audi = new Car(5);
        bmw = new Car(45);
    }

    @Test
    void wash_andDirtinessIs0() {
        premiumWash.wash(audi, tauno);
        assert audi.getDirtiness() == 0;
    }

    @Test
    void dry() {
        premiumWash.dry(audi, tauno);
        assert premiumWash.getSessionDuration() == 30;
    }

    @Test
    void getWashAndDryPrice() {
        assert premiumWash.getWashAndDryPrice() == 70;
    }

    @Test
    void getWashPrice() {
        assert premiumWash.getWashPrice() == 60;
    }
}
