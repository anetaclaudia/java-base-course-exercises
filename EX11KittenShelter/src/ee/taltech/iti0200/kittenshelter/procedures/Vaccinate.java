package ee.taltech.iti0200.kittenshelter.procedures;

public class Vaccinate implements Procedure {
    private String name;
    private int price;

    public Vaccinate(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

}
