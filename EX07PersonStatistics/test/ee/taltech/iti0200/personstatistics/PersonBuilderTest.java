package ee.taltech.iti0200.personstatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PersonBuilderTest {
    Person mari = new Person("mari",
            "mets",
            31,
            Gender.FEMALE,
            1.7,
            "nurse",
            "estonia");

    PersonBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new PersonBuilder();
    }


    @Test
    void build() {
        builder.setFirstName("mari");
        builder.setLastName("mets");
        builder.setAge(31);
        builder.setGender("FEMALE");
        builder.setHeight(1.7);
        builder.setOccupation("nurse");
        builder.setNationality("estonia");
        assert builder.build().equals(mari);

    }
}
