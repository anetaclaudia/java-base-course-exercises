package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import ee.taltech.iti0200.bonuscards.cards.CoopCard;
import ee.taltech.iti0200.bonuscards.cards.RimiCard;
import ee.taltech.iti0200.bonuscards.exceptions.AlreadyExistingCardTypeException;
import ee.taltech.iti0200.bonuscards.exceptions.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {
    Person kalle;
    Person malle;
    Store rimi;
    Store coop;
    RimiCard rimiCard;
    CoopCard coopCard;

    @BeforeEach
    void setUp() {
        kalle = new Person(
                "Kalle",
                "Kuusk",
                25,
                Person.Gender.MALE
        );

        malle = new Person(
                "Malle",
                "Mänd",
                25,
                Person.Gender.FEMALE
        );

        rimiCard = new RimiCard(rimi, kalle);
        coopCard = new CoopCard(coop, kalle);


        Set<BonusCard> bonusCards = new HashSet<>(Arrays.asList(coopCard));
    }

    @Test
    void getFirstName() {
        assert kalle.getFirstName().equals("Kalle");
    }

    @Test
    void getLastName() {
        assert malle.getLastName().equals("Mänd");
    }

    @Test
    void getAge() {
        assert kalle.getAge() == 25;
    }

    @Test
    void setAge() {
        malle.setAge(26);
//        System.out.println(malle.getAge());
//        assert malle.getAge() == 26;
    }

    @Test
    void setSmallAge() {
        assertThrows(PersonException.class, () -> {
            kalle.setAge(0);
        });
    }

    @Test
    void getGender() {
        assert kalle.getGender().equals(Person.Gender.MALE);
    }

    @Test
    void getBonusCards() {
        kalle.addBonusCard(rimiCard);
        assert kalle.getBonusCards().contains(rimiCard);
    }

    @Test
    void getBonusCardByType() {
        kalle.addBonusCard(rimiCard);
        assertEquals(kalle.getBonusCardByType(BonusCard.CardType.RIMI), Optional.of(rimiCard));

    }

    @Test
    void getBonusCardWhenNoCards() {
        assertEquals(kalle.getBonusCardByType(BonusCard.CardType.RIMI), Optional.empty());
    }

    @Test
    void getBonusCardByTypeWhenNoCard() {
        assertEquals(kalle.getBonusCardByType(BonusCard.CardType.RIMI), Optional.empty());
    }

    @Test
    void addBonusCard() {
        Set<BonusCard> cards = new HashSet<>(Arrays.asList(rimiCard));
        kalle.addBonusCard(rimiCard);
        assert kalle.getBonusCards().equals(cards);
    }

    @Test
    void addBonusCardButThrowsException() {
        Set<BonusCard> cards = new HashSet<>(Arrays.asList(coopCard, rimiCard));
        kalle.addBonusCard(rimiCard);
        assertThrows(AlreadyExistingCardTypeException.class, () -> {
            kalle.addBonusCard(rimiCard);
        });
    }

    @Test
    void removeBonusCard() {
        kalle.addBonusCard(rimiCard);
        kalle.removeBonusCard(rimiCard);
        assert kalle.getBonusCards().equals(Collections.emptySet());
    }
}
