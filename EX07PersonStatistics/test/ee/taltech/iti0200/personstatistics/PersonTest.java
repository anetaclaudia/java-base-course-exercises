package ee.taltech.iti0200.personstatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PersonTest {
    Person mari;

    @BeforeEach
    void setUp() {
        mari = new Person("mari",
                "mets",
                31,
                Gender.FEMALE,
                1.7,
                "nurse",
                "estonia");
    }

    @Test
    void getFirstName() {
        assert mari.getFirstName().equals("mari");
    }

    @Test
    void getLastName() {
        assert mari.getLastName().equals("mets");
    }

    @Test
    void getAge() {
        assert mari.getAge() == 31;
    }

    @Test
    void getGender() {
        assert mari.getGender().equals(Gender.FEMALE);
    }

    @Test
    void getHeightInMeters() {
        assert mari.getHeightInMeters() == 1.7;
    }

    @Test
    void getOccupation() {
        assert mari.getOccupation().equals("nurse");
    }

    @Test
    void getNationality() {
        assert mari.getNationality().equals("estonia");
    }
}
