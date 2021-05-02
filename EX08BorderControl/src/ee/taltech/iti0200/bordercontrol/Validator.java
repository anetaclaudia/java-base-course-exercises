package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.entity.Goods;
import ee.taltech.iti0200.bordercontrol.entity.Person;
import ee.taltech.iti0200.bordercontrol.entity.Vehicle;

public interface Validator {
    // implement it according to Visitor pattern

//    void accept(BorderEntity visitor);

    boolean validate(Goods goods);

    boolean validate(Vehicle vehicle);

    boolean validate(Person person);
}
