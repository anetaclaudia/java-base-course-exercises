package ee.taltech.iti0200.kittenshelter.procedures;

import org.junit.jupiter.api.Test;


class VaccinateTest {

    Procedure vaccinate = new Vaccinate("vaccinate", 10);

    @Test
    void getName() {
        assert vaccinate.getName().equals("vaccinate");
    }

    @Test
    void getPrice() {
        assert vaccinate.getPrice() == 10;
    }
}
