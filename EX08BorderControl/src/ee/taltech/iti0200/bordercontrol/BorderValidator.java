package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import ee.taltech.iti0200.bordercontrol.entity.Goods;
import ee.taltech.iti0200.bordercontrol.entity.Person;
import ee.taltech.iti0200.bordercontrol.entity.Vehicle;

public class BorderValidator implements Validator {
    Database database = new DatabaseImpl();

    public BorderValidator(Database database) {
        this.database = database;
    }

    @Override
    public boolean validate(Goods goods) {
        return !(database.getIllegalGoods().contains(goods.getProductId()));
    }

    @Override
    public boolean validate(Vehicle vehicle) {
        return !(database.getStolenVehicles().contains(vehicle.getVin()));
    }

    @Override
    public boolean validate(Person person) {
        return !(database.getMissingPersons().contains(person.getIdCode()))
                && !(database.getMissingPersons().contains(person.getName()))
                && !(database.getTerrorists().contains(person.getIdCode()))
                && !(database.getTerrorists().contains(person.getName()));
    }
}
