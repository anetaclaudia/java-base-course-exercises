package ee.taltech.iti0200.kittenshelter.kitten;

import org.junit.jupiter.api.Test;


class KittenTest {
    Kitten kitti = new Kitten("kitti", Gender.FEMALE, Colour.ORANGE, true);

    @Test
    void getName() {
        assert kitti.getName().equals("kitti");
    }

    @Test
    void getGender() {
        assert kitti.getGender().equals(Gender.FEMALE);
    }

    @Test
    void getColour() {
        assert kitti.getColour().equals(Colour.ORANGE);
    }

    @Test
    void getsAlongWithOthers() {
        assert kitti.getsAlongWithOthers;
    }
}
