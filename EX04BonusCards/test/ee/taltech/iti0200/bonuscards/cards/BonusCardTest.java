package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class BonusCardTest {
    Person kalle;
    CoopCard coopCard;
    RimiCard rimiCard;
    Store coop;
    Store rimi;

    @BeforeEach
    void setUp() {
        kalle = new Person(
                "Kalle",
                "Kuusk",
                25,
                Person.Gender.MALE
        );

        coop = new Store("coop");

        rimi = new Store("rimi");

        coopCard = new CoopCard(coop, kalle);

        rimiCard = new RimiCard(rimi, kalle);
    }

    @Test
    void createCard() {

    }


    @Test
    void useBonus() {
        rimiCard.setBonusBalance(BigDecimal.valueOf(100));
        rimiCard.useBonus(BigDecimal.valueOf(10));
        assert rimiCard.getBonusBalance().equals(BigDecimal.valueOf(90));
    }

    @Test
    void setBonusBalance() {
        rimiCard.setBonusBalance(BigDecimal.valueOf(100));
        assert rimiCard.getBonusBalance().equals(BigDecimal.valueOf(100));
    }

    @Test
    void getType() {
        assert rimiCard.getType().equals(BonusCard.CardType.RIMI);
    }

    @Test
    void getStore() {
        assert rimiCard.getStore().equals(rimi);
    }

    @Test
    void getPerson() {
        assert rimiCard.getPerson().equals(kalle);
    }
}
