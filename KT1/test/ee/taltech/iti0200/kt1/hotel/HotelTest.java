package ee.taltech.iti0200.kt1.hotel;

import ee.taltech.iti0200.kt1.hotel.exceptions.AlreadyExistingRoomException;
import ee.taltech.iti0200.kt1.hotel.exceptions.NotExistingRoomException;
import ee.taltech.iti0200.kt1.hotel.rooms.Room;
import ee.taltech.iti0200.kt1.hotel.rooms.RoomType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HotelTest {
    Hotel hotel;
    Room presidentSuite;
    Room singleRegular;
    Room doubleRegular;
    Room empressSuite;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("Example");

        presidentSuite = new Room(1, "President's suite", RoomType.SUITE, 2);
        singleRegular = new Room(2, "SingleRegular", RoomType.REGULAR, 1);
        doubleRegular = new Room(3, "Double Regular", RoomType.REGULAR, 2);
        empressSuite = new Room(4, "Empress's suite", RoomType.SUITE, 1);
    }

    @Test
    void addRoom() {
        Set<Room> test = Set.of(presidentSuite, singleRegular, doubleRegular, empressSuite);

        hotel.addRoom(presidentSuite);
        hotel.addRoom(singleRegular);
        hotel.addRoom(doubleRegular);
        hotel.addRoom(empressSuite);

        assert hotel.getRoomList().equals(test);
    }

    @Test
    void addExistingRoom() {
        hotel.addRoom(presidentSuite);
        hotel.addRoom(singleRegular);
        hotel.addRoom(doubleRegular);
        hotel.addRoom(empressSuite);
        assertThrows(AlreadyExistingRoomException.class, () -> {
            hotel.addRoom(empressSuite);
        });
    }

    @Test
    void bookRoom() {
        hotel.addRoom(presidentSuite);
        hotel.bookRoom(presidentSuite);
        assert presidentSuite.isBooked();
    }

    @Test
    void bookNotExistingRoom() {
        Room test = new Room(5, "test", RoomType.REGULAR, 1);
        assertThrows(NotExistingRoomException.class, () -> {
            hotel.bookRoom(test);
        });
    }

    @Test
    void cancelBookingForRegularRoom() {
        hotel.addRoom(singleRegular);
        hotel.bookRoom(singleRegular);
        hotel.cancelBooking(singleRegular);
        assert !singleRegular.isBooked();
    }

    @Test
    void getRoomsBySize() {
        Set<Room> test = Set.of(singleRegular, empressSuite);

        hotel.addRoom(presidentSuite);
        hotel.addRoom(singleRegular);
        hotel.addRoom(doubleRegular);
        hotel.addRoom(empressSuite);

        assert hotel.getRoomsBySize(1).equals(test);
    }
}
