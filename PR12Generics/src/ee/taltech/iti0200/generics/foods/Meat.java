package ee.taltech.iti0200.generics.foods;

public class Meat extends Food {
    protected String name = "MEAT";

    public Meat() {
        super();
    }

    @Override
    public String getName() {
        return name;
    }
}
