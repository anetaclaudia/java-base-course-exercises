package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.BorderValidator;
import ee.taltech.iti0200.bordercontrol.Validator;
import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import org.junit.jupiter.api.Test;


class GoodsTest {

    Goods goods = new Goods(1L);
    Database db = new DatabaseImpl();
    Validator validator = new BorderValidator(db);

    @Test
    void getProductId() {
        assert goods.getProductId() == 1L;
    }

    @Test
    void accept() {
        assert goods.accept(validator);
    }
}
