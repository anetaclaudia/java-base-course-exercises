package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.Validator;

public class Person extends BorderEntity {
    String name;
    String idCode;

    public Person(String name, String idCode) {
        this.name = name;
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public String getIdCode() {
        return idCode;
    }

    @Override
    public boolean accept(Validator validator) {
        return validator.validate(this);
    }
}
