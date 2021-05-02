package ee.taltech.iti0200.bordercontrol.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DatabaseImplTest {
    Database db;
    String illegalVehicle;
    String goodVehicle1;
    String goodVehicle2;
    Long illegalGoods;
    Long goodGoods1;
    Long goodGoods2;
    String missingPerson;
    String terrorist;
    String person1;
    String person2;

    @BeforeEach
    void setUp() {
        db = new DatabaseImpl();
        illegalVehicle = "bmw";
        goodVehicle1 = "audi";
        goodVehicle2 = "skoda";
        illegalGoods = 1L;
        goodGoods1 = 2L;
        goodGoods2 = 3L;
        missingPerson = "mari";
        terrorist = "mart";
        person1 = "martin";
        person2 = "pets";
    }

    @Test
    void getStolenVehicles() {
        List<String> test = new ArrayList<>(List.of(illegalVehicle));
        db.setStolenVehicles(List.of(illegalVehicle));
        assert db.getStolenVehicles().equals(test);
    }

    @Test
    void getMissingPersons() {
        List<String> test = new ArrayList<>(List.of(missingPerson, person2));
        db.setMissingPersons(List.of(missingPerson, person2));
        assert db.getMissingPersons().equals(test);
    }

    @Test
    void getTerrorists() {
        List<String> test = new ArrayList<>(List.of(terrorist, person1));
        db.setTerrorists(List.of(terrorist, person1));
        assert db.getTerrorists().equals(test);
    }

    @Test
    void getIllegalGoods() {
        List<Long> test = new ArrayList<>(List.of(illegalGoods));
        db.setIllegalGoods(List.of(illegalGoods));
        assert db.getIllegalGoods().equals(test);
    }
}
