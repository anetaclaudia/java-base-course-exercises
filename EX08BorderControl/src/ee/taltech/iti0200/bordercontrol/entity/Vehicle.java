package ee.taltech.iti0200.bordercontrol.entity;


import ee.taltech.iti0200.bordercontrol.Validator;

public class Vehicle extends BorderEntity {
    String vin;

    public Vehicle(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean accept(Validator validator) {
        return validator.validate(this);
    }
}
