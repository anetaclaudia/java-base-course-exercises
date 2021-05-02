package ee.taltech.iti0200.bonuscards.cards;

import ee.taltech.iti0200.bonuscards.Person;
import ee.taltech.iti0200.bonuscards.Store;

import java.math.BigDecimal;

public final class RimiCard extends BonusCard {
    public RimiCard(Store store, Person person) {
        super(store, person);
        bonus = BigDecimal.ZERO;
        cardType = CardType.RIMI;

    }

    /**
     * Collects bonus on the specified payment amount.
     *
     * @param paymentAmount the payment amount
     * @return collected bonus
     */
    @Override
    public BigDecimal collectBonus(double paymentAmount) {
        if (paymentAmount < 10.0) {
            return BigDecimal.ZERO;
        }
        BigDecimal collectedBonus = BigDecimal.valueOf(paymentAmount).multiply(BigDecimal.valueOf(0.02));
        bonus = bonus.add(collectedBonus);
        return collectedBonus;
    }
}
