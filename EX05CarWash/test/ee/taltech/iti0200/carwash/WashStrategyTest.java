package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WashStrategyTest {
    WashStrategy washStrategy;
    CarOwner kai;
    CarOwner tauno;
    Car bmw;

    @BeforeEach
    void setUp() {
        washStrategy = new PremiumWash();
        kai = new CarOwner("Kai", 72000);
        tauno = new CarOwner("Tauno", 1500);
        bmw = new Car(75);
    }

    @Test
    void isClientBlacklistedIfPersonIsBlacklisted() {
        assert washStrategy.isClientBlacklisted(kai.getName());
    }

    @Test
    void isClientBlacklisted() {
        assert washStrategy.isClientBlacklisted(tauno.getName()) == false;
    }

    @Test
    void setSessionDuration() {
        washStrategy.setSessionDuration(15);
        assert washStrategy.getSessionDuration() == 15;
    }

    @Test
    void getSessionDuration() {
        System.out.println(washStrategy.getSessionDuration());
//        assert washStrategy.getSessionDuration() == 20;
    }

    @Test
    void setSessionPrice() {
        washStrategy.setSessionPrice(70);
        assert washStrategy.getSessionPrice() == 70;
    }

    @Test
    void getSessionPrice() {
        System.out.println(washStrategy.getSessionPrice());
//        assert washStrategy.getSessionPrice() == 60;
    }
}
