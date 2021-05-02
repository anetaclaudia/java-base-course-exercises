package ee.taltech.iti0200.carwash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarOwnerTest {
    CarOwner siim;

    @BeforeEach
    void setUp() {
        siim = new CarOwner("Siim", 1500);
    }

    @Test
    void setBalance() {
        siim.setBalance(1200);
        assert siim.getBalance() == 1200;
    }

    @Test
    void getBalance() {
        assert siim.getBalance() == 1500;
    }

    @Test
    void getName() {
        assert siim.getName().equals("Siim");
    }
}
