package ee.taltech.iti0200.steakhouse.strategy;

import ee.taltech.iti0200.steakhouse.steak.SteakType;

public class CookMedium implements CookStrategy {

    public static final double REDUCE_PERCENTAGE = 0.01;

    @Override
    public double calculateWeightLoss(String cookName, SteakType steakType) {
        int chefNameLength = cookName.length();
        int steakTypeMass = steakType.getMass();
        return (chefNameLength * REDUCE_PERCENTAGE) * steakTypeMass;
    }
}
