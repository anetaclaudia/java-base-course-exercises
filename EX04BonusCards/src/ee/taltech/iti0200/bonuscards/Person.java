package ee.taltech.iti0200.bonuscards;

import ee.taltech.iti0200.bonuscards.cards.BonusCard;
import ee.taltech.iti0200.bonuscards.exceptions.AlreadyExistingCardTypeException;
import ee.taltech.iti0200.bonuscards.exceptions.PersonException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Person {
    public String firstName;
    public String lastName;
    public int age;
    public Gender gender;
    public Set<BonusCard> bonusCards = new HashSet<>();


    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = setAge(age);
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Integer setAge(int age) {
        if (age < 1) {
            throw new PersonException();
        } else {
            return age;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public Set<BonusCard> getBonusCards() {
        return bonusCards;
    }

    /**
     * Gets bonus card by the specified type.
     *
     * @param cardType the bonus card type
     * @return bonus card with the specified type
     */
    public Optional<BonusCard> getBonusCardByType(BonusCard.CardType cardType) {
        for (BonusCard bonusCard : bonusCards) {
            if (bonusCard.getType().equals(cardType)) {
                return Optional.of(bonusCard);
            }
        }
        return Optional.empty();
    }

    public void addBonusCard(BonusCard bonusCard) {
//        if (!bonusCards.contains(bonusCard)) {
//            bonusCards.add(bonusCard);
//        } else {
//            throw new AlreadyExistingCardTypeException();
//        }
        if (bonusCards.isEmpty()) {
            bonusCards.add(bonusCard);
            return;
        } else {
            for (BonusCard card : bonusCards) {
                if (!card.getType().equals(bonusCard.cardType)) {
                    bonusCards.add(bonusCard);
                    return;
                }
            }
        }
        throw new AlreadyExistingCardTypeException();
    }

    public void removeBonusCard(BonusCard bonusCard) {
        if (bonusCards.contains(bonusCard)) {
            bonusCards.remove(bonusCard);
        }
    }
}
