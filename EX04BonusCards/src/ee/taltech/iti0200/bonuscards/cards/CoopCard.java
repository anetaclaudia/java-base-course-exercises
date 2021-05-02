package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

public final class CoopCard extends BonusCard {
    public CoopCard(Store store, Person person) {
        super(store, person);
        bonus = BigDecimal.valueOf(10.0);
        cardType = CardType.COOP;
    }

    /**
     * Collects bonus on the specified payment amount.
     *
     * @param paymentAmount the payment amount
     * @return collected bonus
     */
    @Override
    public BigDecimal collectBonus(double paymentAmount) {
        // 5% boonusrahana
        BigDecimal collectedBonus = BigDecimal.valueOf(paymentAmount).multiply(BigDecimal.valueOf(0.05));
        bonus = bonus.add(collectedBonus);
        return collectedBonus;
    }
}
