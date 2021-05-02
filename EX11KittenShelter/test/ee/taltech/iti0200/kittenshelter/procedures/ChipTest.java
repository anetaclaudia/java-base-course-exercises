package ee.taltech.iti0200.kittenshelter.procedures;

import org.junit.jupiter.api.Test;


class ChipTest {

    Procedure chip = new Chip("chip", 20);

    @Test
    void getName() {
        assert chip.getName().equals("chip");
    }

    @Test
    void getPrice() {
        assert chip.getPrice() == 20;
    }
}
