package ee.taltech.iti0200.personstatistics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class CsvPersonMapperTest {

    Person mari = new Person("mari",
            "mets",
            31,
            Gender.FEMALE,
            1.7,
            "nurse",
            "estonia");

    Person martin = new Person("martin",
            "mets",
            32,
            Gender.MALE,
            1.8,
            "driver",
            "estonia");

    Person mary = new Person("mary",
            "smith",
            44,
            Gender.FEMALE,
            1.6,
            "manager",
            "uk");

    List<Person> testPeople = Arrays.asList(martin, mari, mary);

    @Test
    void mapToPersons() {
        CsvPersonMapper mapper = new CsvPersonMapper();
        List<Person> x = mapper.mapToPersons("example.csv");
//        System.out.println("s");
        assert x.equals(testPeople);
    }
}
