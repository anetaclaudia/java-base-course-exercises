package ee.taltech.iti0200.lambda;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda {

    public static final double BMI_LOWEST_NORMAL = 18.5;
    public static final double BMI_HIGHEST_NORMAL = 24.9;
    private List<Person> personList;

    public Lambda(List<Person> personList) {
        this.personList = personList;
    }

    public Optional<Person> findTheTallestPerson() {
        if (personList.isEmpty()) {
            return Optional.empty();
        } else {
            return personList.stream().max(Comparator.comparing(Person::getHeight));
        }
    }

    public List<Person> filterListByGender(String gender) {
        return personList.stream()
                .filter(person -> person.getGender().equals(gender) || person.getGender().equals("Undefined"))
                .collect(Collectors.toList());
    }

    public List<Person> filterListByAge(Integer bottomAge, Integer upperAge) {
        return personList.stream()
                .filter(person -> (bottomAge <= person.getAge()) && (person.getAge() <= upperAge))
                .collect(Collectors.toList());
    }

    public List<Person> filterListByBMI() {
        return personList.stream()
                .filter(person ->
                        (BMI_LOWEST_NORMAL <= person.calculateBMI()) && (person.calculateBMI() <= BMI_HIGHEST_NORMAL))
                .collect(Collectors.toList());
    }

    public BigInteger getTheRatingProduct() {
        return personList.stream().mapToLong(Person::getRating)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public List<Person> sortByNameLength() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::calculateFullNameLength).reversed())
                .collect(Collectors.toList());
    }

    public List<Integer> getListOfIncreasedRatings(Integer number) {
        return personList.stream().map(person -> person.increaseRating(number)).collect(Collectors.toList());
    }

    public List<Person> getPeopleWithTheLowestRating() {
        Optional<Person> lowestRating = personList.stream().min(Comparator.comparing(Person::getRating));
        return personList.stream()
                .filter(person -> person.getRating().equals(lowestRating.get().getRating()))
                .collect(Collectors.toList());
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
