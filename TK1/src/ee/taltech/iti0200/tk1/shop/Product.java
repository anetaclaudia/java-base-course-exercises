package ee.taltech.iti0200.tk1.shop;

public class Product {
    private String name;
    private int price;

    public Product(int price) {
        this.price = price;
    }

    public Product(String name, int i) {

    }

    public String toString() {
        if (name.equals("")) {
            return String.format("(%s)", price);
        } else {
            return String.format("%s (%s)", name, price);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
