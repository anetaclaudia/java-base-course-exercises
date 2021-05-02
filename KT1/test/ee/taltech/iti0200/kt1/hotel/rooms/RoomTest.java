package ee.taltech.iti0200.kt1.hotel.rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {
    Room presidentSuite;

    @BeforeEach
    void setUp() {
        presidentSuite = new Room(1, "President's suite", RoomType.SUITE, 2);

    }

    @Test
    void getRoomId() {
        assertEquals(1, presidentSuite.getRoomId());
    }

    @Test
    void getName() {
        assertEquals("President's suite", presidentSuite.getName());
    }

    @Test
    void getType() {
        assertEquals(RoomType.SUITE, presidentSuite.getType());
    }

    @Test
    void getSleepingPlaces() {
        assertEquals(2, presidentSuite.getSleepingPlaces());
    }

    @Test
    void setBooked() {
        presidentSuite.setBooked(true);
        assertTrue(presidentSuite.isBooked());
    }
}
