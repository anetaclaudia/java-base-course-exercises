package ee.taltech.iti0200.personstatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


class PersonStatisticsTest {
    Person mari;
    Person martin;
    Person mary;
    PersonStatistics statistics;
    List<Person> testPeople = new ArrayList<>();


    @BeforeEach
    void setUp() {
        mari = new Person("mari",
                "mets",
                31,
                Gender.FEMALE,
                1.7,
                "nurse",
                "estonia");

        martin = new Person("martin",
                "mets",
                32,
                Gender.MALE,
                1.8,
                "driver",
                "estonia");

        mary = new Person("mary",
                "smith",
                44,
                Gender.FEMALE,
                1.6,
                "manager",
                "uk");
        testPeople.add(mari);
        testPeople.add(martin);
        testPeople.add(mary);
        statistics = new PersonStatistics(testPeople);

    }

    @Test
    void countPersons() {
        assert statistics.persons.size() == 3;
    }

    @Test
    void findAverageHeight() {
        assert statistics.findAverageHeight().getAsDouble() == 1.7;
    }

    @Test
    void findYoungestPerson() {
        assert statistics.findYoungestPerson().equals(Optional.of(mari));
    }

    @Test
    void findOldestPerson() {
        assert statistics.findOldestPerson().equals(Optional.of(mary));
    }

    @Test
    void findLongestLastName() {
        assert statistics.findLongestLastName().equals(Optional.of("smith"));
    }

    @Test
    void getNationalityData() {
        List<String> test = Arrays.asList("estonia", "estonia", "uk");
        assert statistics.getNationalityData().equals(test);
    }

    @Test
    void getHeightInCm() {
        List<Double> test = Arrays.asList(170.00, 180.00, 160.00);
        assert statistics.getHeightInCm().equals(test);
    }

    @Test
    void findSamplesWhenSizeLessThanZero() {
        assert statistics.findSamples(-2).equals(Collections.emptyList());
    }

    @Test
    void findSamples() {
        List<Person> test = Arrays.asList(mari, martin);
        assert statistics.findSamples(2).equals(test);
    }

    @Test
    void findSamplePerson() {
    }

    @Test
    void getDistinctFirstNames() {
        Set<Person> test = new HashSet(Arrays.asList("mari", "martin", "mary"));
        assert statistics.getDistinctFirstNames().equals(test);
    }

    @Test
    void getReverseOrderedByHeight() {
    }

    @Test
    void findBetweenAge() {
    }

    @Test
    void findSameLetterNameAndNationality() {
    }

    @Test
    void mapOccupationToPersons() {
    }
}
