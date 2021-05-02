package ee.taltech.iti0200.sum100;

public class TestNumber implements MagicNumber {

    private short number;
    boolean canBeSubtracted;
    boolean canBePlacedNextToOther;

    public TestNumber(short number, boolean canBeSubtracted, boolean canBePlacedNextToOther) {
        this.number = number;
        this.canBeSubtracted = canBeSubtracted;
        this.canBePlacedNextToOther = canBePlacedNextToOther;
    }

    @Override
    public short getNumber() {
        return number;
    }

    @Override
    public boolean canBeSubtracted() {
        return canBeSubtracted;
    }

    @Override
    public boolean canBePlacedNextToOther() {
        return canBePlacedNextToOther;
    }
}

