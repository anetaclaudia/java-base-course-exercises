package ee.taltech.iti0200.cakeorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CakeOrderProcessor {

    private int orderNumber = 0;

    public enum CakeOrderProcessorType {

        MAKE_DAIRY_FREE,
        COUNT_TOTAL_SUM,
        REMOVE_BEST_BEFORE_DAY_OVER

    }

    private CakeOrderProcessorType type;

    public CakeOrderProcessor(CakeOrderProcessorType type) {
        this.type = type;
    }

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String process(String jsonInput) {
        orderNumber++;
        Bakery bakery = gson.fromJson(jsonInput, Bakery.class);
        bakery.setOrderId(orderNumber);
        bakery.processCakes();
        if (this.type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {
            bakery.makeDairyFree();
        } else if (this.type.equals(CakeOrderProcessorType.COUNT_TOTAL_SUM)) {
            bakery.countTotalSum();
        } else if (this.type.equals(CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER)) {
            bakery.removeBBDOver();
        }
        return gson.toJson(bakery);
    }

//    public static void main(String[] args) {
//        CakeOrderProcessor x = new CakeOrderProcessor(CakeOrderProcessorType.MAKE_DAIRY_FREE);
//    }
}
