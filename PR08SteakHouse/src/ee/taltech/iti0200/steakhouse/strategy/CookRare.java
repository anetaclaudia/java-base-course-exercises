package ee.taltech.iti0200.steakhouse.strategy;

import ee.taltech.iti0200.steakhouse.steak.SteakType;

public class CookRare implements CookStrategy {

    @Override
    public double calculateWeightLoss(String cookName, SteakType steakType) {
        int chefNameLength = cookName.length();
//        int steakTypeMass = steakType.getMass();
        if (chefNameLength % 2 == 0) {
            return 0;
        } else {
            return chefNameLength;
        }
    }
}
