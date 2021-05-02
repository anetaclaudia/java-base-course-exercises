package ee.taltech.iti0200.warehouses;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Company {
    private String name;
    private Set<Warehouse> warehouses = new HashSet<>();
    private Set<Worker> officeWorkers = new HashSet<>();
    private Set<Product> products = new HashSet<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Gets the cheapest product for customer.
     *
     * @return the cheapest product
     */
    public Optional<Product> getCheapestProductForCustomer() {
        if (products.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.of(Collections.min(products,
                    Comparator.comparing(Product::getGrossPrice)));
        }
    }

    /**
     * Gets the most expensive product for customer.
     *
     * @return the most expensive product
     */
    public Optional<Product> getMostExpensiveProductForCustomer() {
        if (products.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.of(Collections.max(products,
                    Comparator.comparing(Product::getGrossPrice)));
        }
    }

    /**
     * Reports the current state of products in the warehouses.
     *
     * @return the current state of products in the warehouses
     */
    public Map<Product, Long> reportInventory() {
        Map<Product, Long> inventoryStatus = new HashMap<>();
        for (Warehouse warehouse : warehouses) {
            for (Map.Entry<Product, Long> inventory : warehouse.getInventory().entrySet()) {
                if (!inventoryStatus.containsKey(inventory.getKey())) {
                    inventoryStatus.put(inventory.getKey(), inventory.getValue());
                } else {
                    inventoryStatus.replace(inventory.getKey(),
                            inventoryStatus.get(inventory.getKey()) + inventory.getValue());
                }

            }
        }
        return inventoryStatus;
    }

    /**
     * Finds all warehouses where the product is available.
     *
     * @param product the product to check
     * @return list of warehouses where the product is availalble
     */
    public List<Warehouse> getAvailability(Product product) {
        List<Warehouse> result = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getInventory().containsKey(product)) {
                if (warehouse.getInventory().get(product) >= 1) {
                    result.add(warehouse);
                }
            }
        }
        return result;
    }

    /**
     * Adds specified amount of specified product to all warehouses.
     *
     * @param product the product to add
     * @param amount  the amount of product to add
     */
    public void restockProduct(Product product, Long amount) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getInventory().containsKey(product)) {
                warehouse.getInventory().put(product, warehouse.getInventory().get(product) + amount);
            }
        }
    }

    /**
     * Add a new product to companies products list and all the warehouses of that company.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
        for (Warehouse warehouse : warehouses) {
            warehouse.getInventory().put(product, 0L);
        }
    }

    /**
     * Gets all company workers.
     *
     * @return all company workers
     */
    public Set<Worker> getCompanyWorkers() {
        Set<Worker> allWorkers = new HashSet<>();
        allWorkers.addAll(officeWorkers);
        for (Warehouse warehouse : warehouses) {
            allWorkers.addAll(warehouse.getWorkers());
        }
        return allWorkers;
    }

    /**
     * Add an office worker.
     *
     * @param worker the worker to add
     */
    public void addOfficeWorker(Worker worker) {
        officeWorkers.add(worker);
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    /**
     * Add a warehouse.
     *
     * @param wareHouse the warehouse to add
     */
    public void addWarehouse(Warehouse wareHouse) {
        warehouses.add(wareHouse);
    }

    /**
     * Gets total company goods value.
     *
     * @return total company goods value
     */
    public BigDecimal getCompanyGoodsValue() {
        BigDecimal result = BigDecimal.ZERO;
//        BigDecimal companyProductsPrice = BigDecimal.ZERO;
//        BigDecimal warehouseProductsPrice = BigDecimal.ZERO;

//        for (Product product : products) {
//            BigDecimal productPrice = product.getNetPrice();
//            companyProductsPrice = companyProductsPrice.add(productPrice);
//        }

        for (Warehouse warehouse : warehouses) {
            for (Map.Entry<Product, Long> entry : warehouse.getInventory().entrySet()) {
                BigDecimal productPrice = entry.getKey().getNetPrice();
                BigDecimal productAmount = BigDecimal.valueOf(entry.getValue());
                result = result.add(productPrice.multiply(productAmount));
            }
        }

//        result = result.add(companyProductsPrice).add(warehouseProductsPrice);
        return result;
    }

//    public static void main(String[] args) {
//        Company x = new Company("Test kompanii");
//        Product koka = new Product("Koka koola1", BigDecimal.valueOf(100.0), BigDecimal.valueOf(110.0),
//                BigDecimal.valueOf(120.0));
//        Product koka2 = new Product("Koka koola2", BigDecimal.valueOf(200.0), BigDecimal.valueOf(210.0),
//                BigDecimal.valueOf(220.0));
//        Product koka3 = new Product("Koka koola3", BigDecimal.valueOf(300.0), BigDecimal.valueOf(310.0),
//                BigDecimal.valueOf(320.0));
//        Warehouse hoidla = new Warehouse("kakise");
//        Warehouse hoidla2 = new Warehouse("kakise2");
//        Warehouse hoidla3 = new Warehouse("kakise3");
////
//        Map<Product, Long> map1 = Map.ofEntries(
//                Map.entry(koka, 100L),
//                Map.entry(koka2, 200L),
//                Map.entry(koka3, 300L)
//        );
//        System.out.println(map1);
//        Map<Product, Long> map2 = Map.ofEntries(
//                Map.entry(koka, 500L),
//                Map.entry(koka2, 600L),
//                Map.entry(koka3, 700L)
//        );
//        x.addWarehouse(hoidla);
//        x.addWarehouse(hoidla2);
//        x.addWarehouse(hoidla3);
//        hoidla1.addProduct(Map.entry(koka, 100L));
//        hoidla1.addProduct(Map.entry(koka2, 200L));
//        hoidla1.addProduct(Map.entry(koka3, 300L));
//        hoidla2.addProduct(Map.entry(koka3, 600L));
//        hoidla2.addProduct(Map.entry(koka3, 700L));
//        hoidla2.addProduct(Map.entry(koka3, 800L));
//        x.addProduct(koka);
//        x.addProduct(koka2);
//        x.addProduct(koka3);
//        System.out.println(x.getMostExpensiveProductForCustomer());
//        System.out.println(x.getCompanyGoodsValue()); //
//}
}
