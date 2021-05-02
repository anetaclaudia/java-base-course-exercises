package ee.taltech.iti0200.kittenshelter;

import ee.taltech.iti0200.kittenshelter.kitten.Colour;
import ee.taltech.iti0200.kittenshelter.kitten.Gender;
import ee.taltech.iti0200.kittenshelter.kitten.Kitten;
import org.junit.jupiter.api.Test;

import java.util.Set;


class PersonTest {

    Kitten kitti = new Kitten("kitti", Gender.FEMALE, Colour.ORANGE, false);
    Person mari = new Person("Mari", 200);

    @Test
    void getName() {
        assert mari.getName().equals("Mari");
    }

    @Test
    void addKitten() {
        mari.addKitten(kitti);
        assert mari.getCatsOwned().equals(Set.of(kitti));
    }
}
