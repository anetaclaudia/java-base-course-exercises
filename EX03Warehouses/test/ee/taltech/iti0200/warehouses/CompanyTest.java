package ee.taltech.iti0200.warehouses;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class CompanyTest {
    Company company = new Company("Kompanii");

    Warehouse hoidla1 = new Warehouse("Välja 8");
    Warehouse hoidla2 = new Warehouse("Akadeemia tee 15a");

    Product koka = new Product("Koka koola1", BigDecimal.valueOf(100.0), BigDecimal.valueOf(110.0),
            BigDecimal.valueOf(120.0));
    Product koka2 = new Product("Koka koola2", BigDecimal.valueOf(200.0), BigDecimal.valueOf(210.0),
            BigDecimal.valueOf(220.0));
    Product koka3 = new Product("Koka koola3", BigDecimal.valueOf(300.0), BigDecimal.valueOf(310.0),
            BigDecimal.valueOf(320.0));

    Worker worker = new Worker("Mari", "Mets", "1234567", 20);
    Worker anotherWorker = new Worker("Mart", "Martinson", "123456", 28);

    Worker officeWorker = new Worker("Mart", "Martson", "1256", 28);
    Worker anotherOfficeWorker = new Worker("Marta", "Martson", "126", 24);


    @Test
    void getName() {
        assert company.getName().equals("Kompanii");
    }

    @Test
    void getCheapestProductForCustomerWhenNoProduct() {
        assert company.getCheapestProductForCustomer().equals(Optional.empty());
    }

    @Test
    void testGetCheapestProduct() {
        company.addProduct(koka);
        company.addProduct(koka2);
        company.addProduct(koka3);

        assert company.getCheapestProductForCustomer().equals(Optional.of(koka));
    }

    @Test
    void testGetMostExpensiveProduct() {
        company.addProduct(koka);
        company.addProduct(koka2);
        company.addProduct(koka3);

        assert company.getMostExpensiveProductForCustomer().equals(Optional.of(koka3));
    }

    @Test
    void getMostExpensiveProductForCustomerWhenNoProduct() {
        assert company.getMostExpensiveProductForCustomer().equals(Optional.empty());
    }

    @Test
    void reportInventory() {
        company.addWarehouse(hoidla1);

        Map<Product, Long> map1 = Map.ofEntries(
                Map.entry(koka, 100L),
                Map.entry(koka2, 200L),
                Map.entry(koka3, 300L)
        );

        hoidla1.addProduct(Map.entry(koka, 100L));
        hoidla1.addProduct(Map.entry(koka2, 200L));
        hoidla1.addProduct(Map.entry(koka3, 300L));
        //System.out.println(company.reportInventory());


        assert company.reportInventory().equals(map1);
    }

    @Test
    void reportInventoryManyWarehouses() {
        company.addWarehouse(hoidla1);
        company.addWarehouse(hoidla2);

        Map<Product, Long> map2 = Map.ofEntries(
                Map.entry(koka, 200L)
        );

        hoidla1.addProduct(Map.entry(koka, 100L));
        hoidla2.addProduct(Map.entry(koka, 100L));

        assert company.reportInventory().equals(map2);

    }

    @Test
    void getAvailability() {
        List<Warehouse> testResult = Arrays.asList(hoidla1, hoidla2);

        company.addWarehouse(hoidla1);
        company.addWarehouse(hoidla2);

        hoidla1.addProduct(Map.entry(koka, 100L));
        hoidla2.addProduct(Map.entry(koka, 100L));

        assert company.getAvailability(koka).equals(testResult);
    }

    @Test
    void restockProduct() {
        company.addWarehouse(hoidla1);
        hoidla1.addProduct(Map.entry(koka, 100L));

        Map<Product, Long> map3 = Map.ofEntries(
                Map.entry(koka, 200L)
        );

        company.restockProduct(koka, 100L);
        //System.out.println(company.reportInventory());
        assert company.reportInventory().equals(map3);
    }

    @Test
    void addProduct() {
        company.addWarehouse(hoidla1);

    }

    @Test
    void getCompanyWorkers() {
        Set<Worker> workers = Set.of(officeWorker, anotherOfficeWorker, worker, anotherWorker);
        company.addOfficeWorker(officeWorker);
        company.addOfficeWorker(anotherOfficeWorker);
        company.addWarehouse(hoidla1);
        hoidla1.addWorker(worker);
        hoidla1.addWorker(anotherWorker);

        assert company.getCompanyWorkers().equals(workers);
    }

    @Test
    void addOfficeWorker() {
        Set<Worker> officeWorkers = Set.of(officeWorker, anotherOfficeWorker);
        company.addOfficeWorker(officeWorker);
        company.addOfficeWorker(anotherOfficeWorker);

        assert company.getCompanyWorkers().equals(officeWorkers);
    }

    @Test
    void getWarehouses() {
        company.addWarehouse(hoidla1);
        company.addWarehouse(hoidla2);
        Set<Warehouse> testResult = Set.of(hoidla1, hoidla2);

        assert company.getWarehouses().equals(testResult);
    }

    @Test
    void addWarehouse() {
    }

    @Test
    void getCompanyGoodsValue() {
    }

}
