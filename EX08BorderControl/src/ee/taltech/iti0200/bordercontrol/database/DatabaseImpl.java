package ee.taltech.iti0200.bordercontrol.database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {
    private List<String> stolenVehicles = new ArrayList<>();
    private List<String> missingPersons = new ArrayList<>();
    private List<String> terrorists = new ArrayList<>();
    private List<Long> illegalGoods = new ArrayList<>();

    @Override
    public List<String> getStolenVehicles() {
        return stolenVehicles;
    }

    @Override
    public List<String> getMissingPersons() {
        return missingPersons;
    }

    @Override
    public List<String> getTerrorists() {
        return terrorists;
    }

    @Override
    public List<Long> getIllegalGoods() {
        return illegalGoods;
    }

    @Override
    public void setStolenVehicles(List<String> stolenVehicles) {
        this.stolenVehicles = stolenVehicles;
    }

    @Override
    public void setMissingPersons(List<String> missingPersons) {
        this.missingPersons = missingPersons;
    }

    @Override
    public void setTerrorists(List<String> terrorists) {
        this.terrorists = terrorists;
    }

    @Override
    public void setIllegalGoods(List<Long> illegalGoods) {
        this.illegalGoods = illegalGoods;
    }
}
