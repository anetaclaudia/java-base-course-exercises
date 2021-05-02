package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class WarehouseTest {
    Warehouse hoidla1;
    Warehouse hoidla2;

    Product koka = new Product("Koka koola1", BigDecimal.valueOf(100.0), BigDecimal.valueOf(110.0),
            BigDecimal.valueOf(120.0));
    Product koka2 = new Product("Koka koola2", BigDecimal.valueOf(200.0), BigDecimal.valueOf(210.0),
            BigDecimal.valueOf(220.0));
    Product koka3 = new Product("Koka koola3", BigDecimal.valueOf(300.0), BigDecimal.valueOf(310.0),
            BigDecimal.valueOf(320.0));

    Worker worker = new Worker("Mari", "Mets", "1234567", 20);
    Worker anotherWorker = new Worker("Mart", "Martinson", "123456", 28);

    @BeforeEach
    void setWarehouse() {
        hoidla1 = new Warehouse("Välja 8");
        hoidla2 = new Warehouse("Kotka 9");
    }

    @Test
    void testGetInventory() {
        hoidla1.addProduct(Map.entry(koka, 100L));
        hoidla1.addProduct(Map.entry(koka2, 200L));
        hoidla1.addProduct(Map.entry(koka3, 300L));

        Map<Product, Long> map1 = Map.ofEntries(
                Map.entry(koka, 100L),
                Map.entry(koka2, 200L),
                Map.entry(koka3, 300L)
        );
        assert hoidla1.getInventory().equals(map1);

    }

    @Test
    void testGetAmountContainsKey() {
        hoidla1.addProduct(Map.entry(koka, 100L));
        assert hoidla1.getAmount(koka).equals(100L);
    }

    @Test
    void testGetAmountNoKey() {
        assert hoidla1.getAmount(koka).equals(0L);
    }

    @Test
    void getAddress() {
        assert hoidla1.getAddress().equals("Välja 8");
    }

    @Test
    void testAddProductWhenNoKeys() {
        Map<Product, Long> map2 = Map.ofEntries(
                Map.entry(koka, 500L),
                Map.entry(koka2, 600L),
                Map.entry(koka3, 700L)
        );

        hoidla1.addProduct(Map.entry(koka, 500L));
        hoidla1.addProduct(Map.entry(koka2, 600L));
        hoidla1.addProduct(Map.entry(koka3, 700L));

        assert hoidla1.getInventory().equals(map2);
    }

    @Test
    void testAddProductWhenKeyExists() {
        Map<Product, Long> map3 = Map.ofEntries(
                Map.entry(koka, 300L)
        );

        hoidla1.addProduct(Map.entry(koka, 100L));
        hoidla1.addProduct(Map.entry(koka, 200L));

        assert hoidla1.getInventory().equals(map3);
    }

    @Test
    void hasProduct() {
        hoidla1.addProduct(Map.entry(koka, 100L));

        assert hoidla1.hasProduct(koka);
    }

    @Test
    void testHasNoProduct() {
        assert !(hoidla1.hasProduct(koka));
    }

    @Test
    void testHasEnoughProductWhenNoProduct() {
        assert !(hoidla1.hasEnoughProduct(koka, 10L));
    }

    @Test
    void testHasEnoughProduct() {
        hoidla1.addProduct(Map.entry(koka, 100L));
        assert hoidla1.hasEnoughProduct(koka, 10L);
    }

    @Test
    void getWorkers() {
        hoidla1.addWorker(worker);
        hoidla1.addWorker(anotherWorker);

        Set<Worker> workersTest = new HashSet<>();
        workersTest.add(worker);
        workersTest.add(anotherWorker);

        assert hoidla1.getWorkers().equals(workersTest);
    }

    @Test
    void addWorker() {
        hoidla1.addWorker(anotherWorker);

        Set<Worker> workersTest = new HashSet<>();
        workersTest.add(anotherWorker);

        assert hoidla1.getWorkers().equals(workersTest);
    }

    @Test
    void getInventoryValue() {
        BigDecimal result = BigDecimal.valueOf(100L).multiply(BigDecimal.valueOf(120));

        hoidla1.addProduct(Map.entry(koka, 100L));

        assert !(hoidla1.getInventoryValue().equals(result));

    }

    @Test
    void testEquals() {
        assert !(hoidla1.equals(hoidla2) && hoidla2.equals(hoidla1));
    }

    @Test
    void testHashCode() {
        assert !(hoidla1.hashCode() == hoidla2.hashCode());
    }
}
