package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.BorderValidator;
import ee.taltech.iti0200.bordercontrol.Validator;
import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import org.junit.jupiter.api.Test;


class PersonTest {
    Database db = new DatabaseImpl();
    Validator validator = new BorderValidator(db);
    Person person = new Person("mari", "49908081234");

    @Test
    void getName() {
        assert person.getName().equals("mari");
    }

    @Test
    void getIdCode() {
        assert person.getIdCode().equals("49908081234");
    }

    @Test
    void accept() {
        assert person.accept(validator);
    }
}
