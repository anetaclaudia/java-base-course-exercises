package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.Validator;
import org.junit.jupiter.api.Test;

class BorderEntityTest {
    BorderEntity borderEntity = new BorderEntity() {
        @Override
        public boolean accept(Validator validator) {
            return false;
        }
    };

    @Test
    void getBorderCrossingId() {
        borderEntity.setBorderCrossingId(2L);
        assert borderEntity.getBorderCrossingId() == 2L;
    }

}
