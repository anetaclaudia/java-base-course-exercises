package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import ee.taltech.iti0200.bonuscards.cards.CoopCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class StoreTest {
    Person kalle;
    Person malle;
    Person kalvi;
    Store coop;
    CoopCard coopCardForKalle;
    CoopCard coopCardForMalle;
    CoopCard coopCardForKalvi;


    @BeforeEach
    void setUp() {
        kalle = new Person("kalle", "kalvi", 30, Person.Gender.MALE);
        malle = new Person("malle", "kalle", 25, Person.Gender.FEMALE);
        kalvi = new Person("kalvi", "kalle", 31, Person.Gender.MALE);
        coop = new Store("coop");
        coopCardForKalle = new CoopCard(coop, kalle);
        coopCardForKalle.setBonusBalance(BigDecimal.valueOf(100));
        kalle.addBonusCard(coopCardForKalle);
        coopCardForMalle = new CoopCard(coop, malle);
        coopCardForMalle.setBonusBalance(BigDecimal.valueOf(200));
        malle.addBonusCard(coopCardForMalle);
        coopCardForKalvi = new CoopCard(coop, kalvi);
        coopCardForKalvi.setBonusBalance(BigDecimal.valueOf(60));
        kalvi.addBonusCard(coopCardForKalvi);

    }

    @Test
    void getName() {
        assert coop.getName().equals("coop");
    }

    @Test
    void getCustomers() {
        Set<Person> test = new HashSet<>(List.of(kalle, malle, kalvi));
        coop.addCustomer(kalle);
        coop.addCustomer(malle);
        coop.addCustomer(kalvi);
        assert coop.getCustomers().equals(test);
    }

    @Test
    void getBonuscards() {
        Set<BonusCard> test = new HashSet<>(List.of(coopCardForKalle, coopCardForMalle, coopCardForKalvi));
        assert !(coop.getBonuscards().equals(test));
    }

    @Test
    void addCustomer() {
        coop.addCustomer(kalvi);
        assert coop.getCustomers().equals(new HashSet<>(List.of(kalvi)));
    }

    @Test
    void removeCustomerIfCustomerNotExisting() {
        coop.removeCustomer(kalvi);
        assert coop.getCustomers().equals(Collections.emptySet());
    }

    @Test
    void removeCustomer() {
        coop.addCustomer(kalvi);
        coop.addCustomer(kalle);
        coop.removeCustomer(kalle);
        assert coop.getCustomers().equals(new HashSet<>(List.of(kalvi)));
    }

    @Test
    void getCustomerWithHighestBonusBalance() {
        coop.addCustomer(kalvi);
        coop.addCustomer(kalle);
        coop.addCustomer(malle);
//        System.out.println(coop.getCustomerWithHighestBonusBalance(BonusCard.CardType.COOP));
        assert coop.getCustomerWithHighestBonusBalance(BonusCard.CardType.COOP).equals(Optional.of(malle));
    }

    @Test
    void getCustomerWithHighestBonusBalanceWhenNoCustomers() {
        assert coop.getCustomerWithHighestBonusBalance(BonusCard.CardType.COOP).equals(Optional.empty());
    }

    @Test
    void getCustomerWithLowestBonusBalanceYoungerThan() {
        coop.addCustomer(kalvi);
        coop.addCustomer(kalle);
        coop.addCustomer(malle);
        assert coop.getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType.COOP, 35)
                .equals(Optional.of(kalvi));
    }

    @Test
    void getCustomerWithLowestBonusWhenNoCustomer() {
        assert coop.getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType.COOP, 24)
                .equals(Optional.empty());
    }

    @Test
    void getTotalBonuses() {
        coop.addCustomer(kalvi);
        coop.addCustomer(kalle);
        coop.addCustomer(malle);
        assert coop.getTotalBonuses(BonusCard.CardType.COOP).equals(BigDecimal.valueOf(360));
    }

    @Test
    void getAverageBonusWhenNoBonusCards() {
        coop.removeCustomer(kalvi);
        coop.removeCustomer(kalle);
        coop.removeCustomer(malle);
        assert coop.getAverageBonus(BonusCard.CardType.COOP).equals(BigDecimal.ZERO);
    }

    @Test
    void getAverageBonus() {
        coop.addCustomer(kalvi);
        coop.addCustomer(kalle);
        coop.addCustomer(malle);
        assert coop.getAverageBonus(BonusCard.CardType.COOP).equals(BigDecimal.valueOf(120));
    }
}
