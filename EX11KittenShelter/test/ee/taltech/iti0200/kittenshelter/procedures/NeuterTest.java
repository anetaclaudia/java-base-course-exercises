package ee.taltech.iti0200.kittenshelter.procedures;

import org.junit.jupiter.api.Test;


class NeuterTest {

    Procedure neuter = new Neuter("neuter", 50);

    @Test
    void getName() {
        assert neuter.getName().equals("neuter");
    }

    @Test
    void getPrice() {
        assert neuter.getPrice() == 50;
    }
}
