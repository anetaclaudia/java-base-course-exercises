package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.BorderValidator;
import ee.taltech.iti0200.bordercontrol.Validator;
import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import org.junit.jupiter.api.Test;


class VehicleTest {
    Vehicle vehicle = new Vehicle("WAUD12345678");
    Database db = new DatabaseImpl();
    Validator validator = new BorderValidator(db);

    @Test
    void getVin() {
        assert vehicle.getVin().equals("WAUD12345678");
    }

    @Test
    void accept() {
        assert vehicle.accept(validator);
    }
}
