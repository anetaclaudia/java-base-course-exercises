package ee.taltech.iti0200.steakhouse;

import ee.taltech.iti0200.steakhouse.steak.Steak;
import ee.taltech.iti0200.steakhouse.steak.SteakType;
//import ee.taltech.iti0200.steakhouse.strategy.CookStrategy;

import java.util.ArrayDeque;

public class Kitchen {
    String chefCook;
    ArrayDeque<String> allCooks = new ArrayDeque<>();

    public Kitchen(String chefCook) {
        this.chefCook = chefCook;
    }

    Steak makeOrder(Order order) {
        if (order.getSteakType().equals(SteakType.FILET_MIGNON)) {
            return order.getCookStrategy().makeSteak(chefCook, order.getSteakType());
        } else {
            String cook = allCooks.getFirst();
            allCooks.remove(cook);
            allCooks.addLast(cook);
            return order.getCookStrategy().makeSteak(cook, order.getSteakType());
        }
    }

    void addCook(String cookName) {
        if (!allCooks.contains(cookName)) {
            allCooks.add(cookName);
        }
    }

    ArrayDeque<String> getAllCooks() {
        return allCooks;
    }
}
