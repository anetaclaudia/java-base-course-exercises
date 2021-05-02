package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CarWashServiceTest {
    CarWashService service;
    WashStrategy strategy;
    CarOwner blackListedOwner;
    CarOwner ownerWithNoMoney;
    CarOwner owner;
    Car bmw;
    Car audi;

    @BeforeEach
    void setUp() {
        service = new CarWashService();
        strategy = new RegularWash();
        blackListedOwner = new CarOwner("Kai", 72000);
        ownerWithNoMoney = new CarOwner("Martin", 0);
        owner = new CarOwner("Siim", 1500);
        bmw = new Car(100);

    }

    @Test
    void setWashStrategy() {
        service.setWashStrategy(strategy);
        assert service.getWashStrategy().equals(strategy);
    }

    @Test
    void washWhenNoStrategy() {
        assert !service.wash(bmw, owner);
    }

    @Test
    void washWhenClientBlacklisted(){
        service.setWashStrategy(strategy);
        assert !service.wash(bmw, blackListedOwner);
    }

    @Test
    void washWhenClientHasNoMoney(){
        service.setWashStrategy(strategy);
        assert !service.wash(bmw, ownerWithNoMoney);
    }

    @Test
    void washAndDry() {
    }
}
