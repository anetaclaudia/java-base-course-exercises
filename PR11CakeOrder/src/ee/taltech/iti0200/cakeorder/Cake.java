package ee.taltech.iti0200.cakeorder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class Cake {
    String cake_id;
    String name;
    String BBD;
    double price;
    double kg;
    List<String> ingredients;

    public void generateCake_id() {
        List<String> nameList = Arrays.asList(this.name.split(" "));
        StringBuilder cake_id = new StringBuilder();
        for (String namePart : nameList) {
            cake_id.append(namePart.charAt(0));
        }
        cake_id.append(nameList.size());
        this.cake_id = cake_id.toString();
    }

    public void makeDairyFree() {
        List<String> dairyList = List.of("milk", "cream-cheese", "yoghurt");
        int i = 0;
        float replacedCount = 0;
        for (String ingredient : ingredients) {
            if (dairyList.contains(ingredient)) {
                ingredients.set(i, "plant-" + ingredient);
                replacedCount++;
            }
            i++;
        }
        if (replacedCount > 0) {
            price = price * (1 + replacedCount / 10);
            NumberFormat formatter = new DecimalFormat("#0.00");
            price = Double.parseDouble(formatter.format(price).replace(",", "."));
        }
    }

    public double calculatePrice() {
        return price * kg;
    }

    public String getBBD() {
        return BBD;
    }
}
