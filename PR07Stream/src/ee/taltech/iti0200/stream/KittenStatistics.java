package ee.taltech.iti0200.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    public OptionalDouble findKittensAverageAge() {
        return kittens.stream()
                .mapToDouble(Kitten::getAge)
                .average();
    }

    public Optional<Kitten> findOldestKitten() {
        return kittens.stream().max(Comparator.comparing(Kitten::getAge));
    }

    public List<Kitten> findYoungestKittens() {
        Optional<Kitten> youngestKitten = kittens.stream().min(Comparator.comparing(Kitten::getAge));
        return kittens.stream()
                .filter(kitten -> kitten.getAge() == youngestKitten.get().getAge())
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream()
                .filter(kitten -> kitten.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream()
                .filter(kitten -> (kitten.getAge() >= minAge) && (kitten.getAge() <= maxAge))
                .collect(Collectors.toList());
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return kittens.stream()
                .filter(kitten -> kitten.getName().toLowerCase().equals(givenName.toLowerCase()))
                .findFirst();
    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream()
                .sorted(Comparator.comparingInt(Kitten::getAge))
                .collect(Collectors.toList());
    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream()
                .sorted(Comparator.comparingInt(Kitten::getAge).reversed())
                .collect(Collectors.toList());
    }

}
