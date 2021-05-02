package ee.taltech.iti0200.personstatistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * For calculating and finding statistical info based on persons.
 */
public class PersonStatistics {
    List<Person> persons;

    public PersonStatistics(List<Person> persons) {
        this.persons = persons;
    }

    public long countPersons() {
        return (long) persons.size();
    }

    public OptionalDouble findAverageHeight() {
        return persons.stream()
                .mapToDouble(Person::getHeightInMeters)
                .average();
    }

    public Optional<Person> findYoungestPerson() {
        return persons.stream()
                .min(Comparator.comparing(Person::getAge));
    }

    public Optional<Person> findOldestPerson() {
        return persons.stream()
                .max(Comparator.comparing(Person::getAge));
    }

    public Optional<String> findLongestLastName() {
        return persons.stream()
                .map(Person::getLastName)
                .max(Comparator.comparingInt(String::length));
    }

    public List<String> getNationalityData() {
        return persons.stream()
                .map(Person::getNationality)
                .collect(Collectors.toList());
    }

    /**
     * Converts persons heights from m to cm.
     *
     * @return list of heights in cm
     */
    public List<Double> getHeightInCm() {
        return persons.stream()
                .map(person -> person.getHeightInMeters() * 100d)
                .collect(Collectors.toList());
    }

    public List<Person> findSamples(int sampleSize) {
        if (sampleSize < 0) {
            return new ArrayList<>();
        }
        return persons.stream()
                .limit(sampleSize)
                .collect(Collectors.toList());
    }

    /**
     * Find first person matching provided parameters criterias.
     *
     * @return first matching person
     */
    public Optional<Person> findSamplePerson(String nationality, Gender gender, int age) {
        return persons.stream()
                .filter(person -> (person.getNationality().equals(nationality)
                        && (person.getGender().equals(gender)) && (person.getAge() == age)))
                .findFirst();
    }

    public Set<String> getDistinctFirstNames() {
        return persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * Order persons from tallest to shortest.
     *
     * @return ordered list of persons
     */
    public List<Person> getReverseOrderedByHeight() {
        return persons.stream()
                .sorted(Comparator.comparingDouble(Person::getHeightInMeters).reversed())
                .collect(Collectors.toList());
    }

    public List<Person> findBetweenAge(int ageFrom, int ageTo) {
        return persons.stream()
                .filter(person -> person.getAge() >= ageFrom && person.getAge() <= ageTo)
                .collect(Collectors.toList());
    }

    /**
     * Find persons whose first name first letter is same as his/her nationality first letter.
     *
     * @return list of matching persons
     */
    public List<Person> findSameLetterNameAndNationality() {
        return persons.stream()
                .filter(person -> person.getNationality().charAt(0) == person.getFirstName().charAt(0))
                .collect(Collectors.toList());
    }

    /**
     * Create map where each occupation has list of persons who have that occupation.
     *
     * @return map of occupations with persons
     */
    public Map<String, List<Person>> mapOccupationToPersons() {
        return persons.stream().collect(Collectors.groupingBy(Person::getOccupation));
    }

//    public static void main(String[] args) {
//        CsvPersonMapper mapper = new CsvPersonMapper();
//        List<Person> persons = mapper.mapToPersons("example.csv");
//        PersonStatistics statistics = new PersonStatistics(persons);
//        System.out.println(statistics.countPersons());
//        System.out.println(statistics.findAverageHeight());
//        System.out.println(statistics.getDistinctFirstNames());
//        System.out.println(statistics.findYoungestPerson());
//        System.out.println(statistics.findOldestPerson());
//        System.out.println(statistics.getNationalityData());
//        System.out.println(statistics.getHeightInCm());
//        System.out.println(statistics.findSamples(-2));
//        System.out.println(statistics.findSamples(6));
//        System.out.println(statistics.findSamplePerson("uk", Gender.MALE, 44));
//        System.out.println(statistics.findSamplePerson("uk", Gender.FEMALE, 44));
//        System.out.println(statistics.findSamplePerson("uk", Gender.FEMALE, 47));
//        System.out.println(statistics.findLongestLastName());
//        System.out.println(statistics.getReverseOrderedByHeight());
//        System.out.println(statistics.findBetweenAge(10, 40));
//        System.out.println(statistics.findSameLetterNameAndNationality());
//        System.out.println(statistics.mapOccupationToPersons());
//    }

}
