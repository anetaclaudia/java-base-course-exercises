package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;
import ee.taltech.iti0200.bonuscards.exceptions.AlreadyExistingCardTypeException;
import ee.taltech.iti0200.bonuscards.exceptions.BonusException;

import java.math.BigDecimal;

public abstract class BonusCard {
    public CardType cardType;
    public Store store;
    public Person person;
    public BigDecimal bonus;

    public enum CardType { COOP, RIMI }

    public BonusCard(Store store, Person person) {
        this.store = store;
        this.person = person;
    }


    /**
     * Creates a bonus card.
     *
     * @param cardType the card type to create
     * @param store    the store to add the card to
     * @param person   the person to add the card to
     * @return the bonus card that was created
     */
    public static BonusCard createCard(CardType cardType, Store store, Person person) {
        BonusCard bonusCard = null;
        if (cardType.equals(CardType.COOP)) {
            bonusCard = new CoopCard(store, person);
            store.addCustomer(person);
            if (person.getBonusCards().contains(bonusCard)) {
                throw new AlreadyExistingCardTypeException();
            } else {
                person.addBonusCard(bonusCard);
            }
        } else if (cardType.equals(CardType.RIMI)) {
            bonusCard = new RimiCard(store, person);
            store.addCustomer(person);
            if (person.getBonusCards().contains(bonusCard)) {
                throw new AlreadyExistingCardTypeException();
            } else {
                person.addBonusCard(bonusCard);
            }
        }
        return bonusCard;
    }

    public abstract BigDecimal collectBonus(double paymentAmount);

    /**
     * Uses the specified amount of bonus.
     *
     * @param value the bonus value to use
     * @return remaining bonus
     */
    public BigDecimal useBonus(BigDecimal value) {
        BigDecimal result = BigDecimal.ZERO;
        if (bonus.compareTo(value) >= 0) {
            result = result.add(bonus.subtract(value));
            bonus = bonus.subtract(value);
        } else {
            throw new BonusException();
        }
        return result;
    }

    public void setBonusBalance(BigDecimal bonusBalance) {
        this.bonus = bonusBalance;
    }

    public CardType getType() {
        return cardType;
    }

    public Store getStore() {
        return store;
    }

    public BigDecimal getBonusBalance() {
        return bonus;
    }

    public Person getPerson() {
        return person;
    }
}
