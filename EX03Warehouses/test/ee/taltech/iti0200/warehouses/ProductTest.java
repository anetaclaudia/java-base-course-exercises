package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class ProductTest {
    Product starter;
    Product redBull;
    Product dynamit;

    @BeforeEach
    void setProduct() {
        starter = new Product("Starter",
                BigDecimal.valueOf(0.5), // weight
                BigDecimal.valueOf(0.6), // netPrice
                BigDecimal.valueOf(1.2)); // grossPrice

        redBull = new Product("Red Bull",
                BigDecimal.valueOf(0.255), // weight
                BigDecimal.valueOf(0.9), // netPrice
                BigDecimal.valueOf(1.6)); // grossPrice

        dynamit = new Product("Dynamit",
                BigDecimal.valueOf(0.6), // weight
                BigDecimal.valueOf(0.5), // netPrice
                BigDecimal.valueOf(0.9)); // grossPrice
    }

    @Test
    void getProductDescriptionForStarter() {
        assert starter.getProductDescription().equals("Starter 1.2 € 0.5 kg");
        // System.out.println(starter.getProductDescription());
    }

    @Test
    void setNameForRedBull() {
        redBull.setName("Red Bull Special Edition");
        assert redBull.getName().equals("Red Bull Special Edition");
    }

    @Test
    void getNameForRedBull() {
        assert redBull.getName().equals("Red Bull");
    }

    @Test
    void getWeightForStarter() {
        assert starter.getWeight().equals(BigDecimal.valueOf(0.5));
    }

    @Test
    void setWeightForDynamit() {
        dynamit.setWeight(BigDecimal.valueOf(0.33));
        assert dynamit.getWeight().equals(BigDecimal.valueOf(0.33));
    }

    @Test
    void setNetPriceForStarter() {
        starter.setNetPrice(BigDecimal.valueOf(1.00));
        assert starter.getNetPrice().equals(BigDecimal.valueOf(1.00));
    }

    @Test
    void getNetPriceForDynamit() {
        assert dynamit.getNetPrice().equals(BigDecimal.valueOf(0.5));

    }

    @Test
    void setGrossPriceForRedBull() {
        redBull.setGrossPrice(BigDecimal.valueOf(1.9));
        assert redBull.getGrossPrice().equals(BigDecimal.valueOf(1.9));
    }

    @Test
    void getGrossPriceForStarter() {
        assert starter.getGrossPrice().equals(BigDecimal.valueOf(1.2));
    }

    @Test
    void getProfitabilityPercentageForStarter() {
        //  (müügihind-omahind) / müügihind * 100
        BigDecimal subtract = BigDecimal.valueOf(1.2).subtract(BigDecimal.valueOf(0.6));
        BigDecimal divide = subtract.divide(BigDecimal.valueOf(1.2)).setScale(4);
        BigDecimal percent = divide.multiply(BigDecimal.valueOf(100));
        assert starter.getProfitabilityPercentage().equals(percent);
//        System.out.println(starter.getProfitabilityPercentage());
    }

    @Test
    void testEquals() {
        assert !(starter.equals(dynamit) && dynamit.equals(starter));
    }

    @Test
    void testHashCode() {
        assert !(redBull.hashCode() == starter.hashCode());
    }
}
