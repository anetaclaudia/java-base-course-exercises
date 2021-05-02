package ee.taltech.iti0200.tk1.shop;

import java.util.List;
import java.util.Optional;

public class Shop {
    private List<Product> products;

    public Shop() {
    }

    public boolean addProduct(Product product) {
        if (product.getPrice() > 0) {
            if (!(products.contains(product))) {
                products.add(product);
            }
            return true;
        }
        return false;
    }


    public Optional<Product> sellProduct(String name, int maxPrice) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getPrice() < maxPrice) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> getProducts() {
        return products;
    }

    public static void main(String[] args) {

        Shop shop = new Shop();
        Product p1 = new Product("Bread", 3);
        Product p2 = new Product("Milk", 4);
        Product p3 = new Product("Milk", 4);
        Product p4 = new Product("Milk", 7);
        Product p5 = new Product("Cheat", -1);
        Product p6 = new Product("", 2);
        Product p7 = new Product(11);
        System.out.println(shop.addProduct(p1));  // true
        System.out.println(shop.addProduct(p2));  // true
        System.out.println(shop.addProduct(p3));  // false
        System.out.println(shop.addProduct(p4));  // true
        System.out.println(shop.addProduct(p5));  // false
        System.out.println(shop.addProduct(p6));  // true
        System.out.println(shop.addProduct(p7));  // true
        System.out.println(shop.sellProduct("Pizza", 10));  // Optional.empty
        System.out.println(shop.sellProduct("Milk", 10).get());  // Milk (7)
        System.out.println(shop.sellProduct("Milk", 10).get());  // Milk (4)
        System.out.println(shop.sellProduct("Milk", 10));  // Optional.empty
        System.out.println(shop.sellProduct("", 20).get());  //  (2)

    }
}
