package ee.taltech.iti0200.kt1.chocolatefactory;

public class ChocolateType {
    int price;
    String stringForm;

    public ChocolateType(int price, String stringForm) {
        this.price = price;
        this.stringForm = stringForm;
    }

    public int getPricePerPiece() {
        return price;
    }

    public String getStringForm() {
        return stringForm;
    }
}
