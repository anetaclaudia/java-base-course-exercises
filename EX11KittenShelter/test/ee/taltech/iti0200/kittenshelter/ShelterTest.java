package ee.taltech.iti0200.kittenshelter;

import ee.taltech.iti0200.kittenshelter.kitten.Colour;
import ee.taltech.iti0200.kittenshelter.kitten.Gender;
import ee.taltech.iti0200.kittenshelter.kitten.Kitten;
import ee.taltech.iti0200.kittenshelter.procedures.Chip;
import ee.taltech.iti0200.kittenshelter.procedures.Neuter;
import ee.taltech.iti0200.kittenshelter.procedures.Vaccinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;


class ShelterTest {
    Kitten kitti;
    Kitten tupsu;
    Kitten kiisu;
    Person mari;
    Person marit;
    Shelter pesaleidja;
    Shelter hoiukodu;
    Neuter neuter;
    Vaccinate vaccinate;
    Chip chip;

    @BeforeEach
    void setUp() {
        pesaleidja = new Shelter("pesaleidja", 150, 2000, 100);
        hoiukodu = new Shelter("hoiukodu", 2, 90, 50);

        kitti = new Kitten("kitti", Gender.FEMALE, Colour.ORANGE, false);

        tupsu = new Kitten("tupsu", Gender.MALE, Colour.COLOURPOINT, true);
        tupsu.setQuarantined(true);

        kiisu = new Kitten("kiisu", Gender.FEMALE, Colour.COLOURPOINT, true);
        kiisu.setChipped(true);
        kiisu.setVaccinated(true);
        kiisu.setNeutered(true);

        pesaleidja.addKitten(kitti);
        pesaleidja.addKitten(tupsu);
        pesaleidja.addKitten(kiisu);

        mari = new Person("Mari", 200);
        marit = new Person("Marit", 70);

        neuter = new Neuter("neuter", 100);
        vaccinate = new Vaccinate("vaccinate", 50);
        chip = new Chip("chip", 20);
    }

    @Test
    void kittensProceduresAreNotDone() {
        assert !(pesaleidja.kittensProceduresAreDone(kitti));
    }

    @Test
    void kittensProceduresAreDone() {
        pesaleidja.toProcedure(neuter, tupsu);
        pesaleidja.toProcedure(chip, tupsu);
        pesaleidja.toProcedure(vaccinate, tupsu);
        assert pesaleidja.kittensProceduresAreDone(tupsu);
    }

    @Test
    void addKitten() {
        pesaleidja.addKitten(tupsu);
        pesaleidja.addKitten(kitti);
        assert pesaleidja.getKittens().equals(Set.of(tupsu, kitti, kiisu));
    }

    @Test
    void getKittens() {
        pesaleidja.addKitten(tupsu);
        pesaleidja.addKitten(kitti);
        pesaleidja.addKitten(kiisu);
        assert pesaleidja.getKittens().equals(Set.of(tupsu, kitti, kiisu));
    }

    @Test
    void canAdoptWhenPersonHasNoMoney() {
        assert !pesaleidja.canAdopt(marit, tupsu, Colour.COLOURPOINT);

    }

    @Test
    void canAdoptWhenCatDoesntGetAlong() {
        assert !pesaleidja.canAdopt(mari, kitti, Colour.ORANGE);
    }

    @Test
    void canAdoptWhenCatIsQuarantined() {
        assert !pesaleidja.canAdopt(mari, tupsu, Colour.COLOURPOINT);
    }

    @Test
    void adoptionFeeIsAdded() {
        pesaleidja.canAdopt(mari, kiisu, Colour.COLOURPOINT);
//        System.out.println(pesaleidja.canAdopt(mari, kiisu, Colour.COLOURPOINT));
        assert pesaleidja.getBudget() == 2100;
    }

    @Test
    void neuterKittenWhenBudgetLow() {
        hoiukodu.toProcedure(neuter, tupsu);
        assert !tupsu.isNeutered();
    }

}
