package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Store {
    private String name;
    private Set<Person> customers = new HashSet<>();
    private Set<BonusCard> bonuscards = new HashSet<>();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getCustomers() {
        return customers;
    }

    public Set<BonusCard> getBonuscards() {
        return bonuscards;
    }

    public void addCustomer(Person person) {
        customers.add(person);
    }

    public void removeCustomer(Person person) {
        if (customers.contains(person)) {
            customers.remove(person);
        }
    }

    /**
     * Gets customer with the highest bonus balance.
     *
     * @param cardType the bonus card type
     * @return customer with the highest bonus balance
     */
    public Optional<Person> getCustomerWithHighestBonusBalance(BonusCard.CardType cardType) {
        Person currentHighestCustomer = null;
        BigDecimal bonusCardMaxValue = BigDecimal.ZERO;

        for (Person customer : customers) {
            for (BonusCard bonuscard : customer.getBonusCards()) {
                if (bonuscard.getType().equals(cardType)) {
                    if (bonuscard.getBonusBalance().compareTo(bonusCardMaxValue) > 0) {
                        currentHighestCustomer = customer;
                        bonusCardMaxValue = bonuscard.getBonusBalance();
                    }
                }
            }
        }
        if (currentHighestCustomer == null) {
            return Optional.empty();
        }
        return Optional.of(currentHighestCustomer);
    }

    /**
     * Gets customer with the lowest bonus balance who is younger than the specified age.
     *
     * @param cardType the bonus card type
     * @param age      the age
     * @return customer
     */
    public Optional<Person> getCustomerWithLowestBonusBalanceYoungerThan(BonusCard.CardType cardType, int age) {
        Person currentLowestCustomer = null;
        BigDecimal bonusCardLowestValue = BigDecimal.valueOf(1000000);

        for (Person customer : customers) {
            if (customer.getAge() < age) {
                for (BonusCard bonuscard : customer.getBonusCards()) {
                    if (bonuscard.getType().equals(cardType)) {
                        if (bonuscard.getBonusBalance().compareTo(bonusCardLowestValue) < 0) {
                            currentLowestCustomer = customer;
                            bonusCardLowestValue = bonuscard.getBonusBalance();
                        }
                    }
                }
            }
        }
        if (currentLowestCustomer == null) {
            return Optional.empty();
        }
        return Optional.of(currentLowestCustomer);
    }

    /**
     * Gets total bonuses.
     *
     * @param cardType the bonus card type
     * @return the total bonuses
     */
    public BigDecimal getTotalBonuses(BonusCard.CardType cardType) {
        BigDecimal result = BigDecimal.ZERO;
        for (Person customer : customers) {
            for (BonusCard bonusCard : customer.getBonusCards()) {
                if (bonusCard.getType().equals(cardType)) {
                    result = result.add(bonusCard.getBonusBalance());
                }
            }
        }
        return result;
    }

    /**
     * Gets average bonus.
     *
     * @param cardType the bonus card type
     * @return the average bonus
     */
    public BigDecimal getAverageBonus(BonusCard.CardType cardType) {
        int bonusCardsAmount = customers.size();
        BigDecimal sumOfBonuses = getTotalBonuses(cardType);
        if (bonusCardsAmount == 0) {
            return BigDecimal.ZERO;
        } else {
            return sumOfBonuses.divide(BigDecimal.valueOf(bonusCardsAmount));
        }
    }
}
