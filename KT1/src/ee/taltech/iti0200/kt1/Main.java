package ee.taltech.iti0200.kt1;

import ee.taltech.iti0200.kt1.hotel.Hotel;
import ee.taltech.iti0200.kt1.hotel.exceptions.SuiteBookingCancellingException;
import ee.taltech.iti0200.kt1.hotel.rooms.Room;
import ee.taltech.iti0200.kt1.hotel.rooms.RoomType;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Example");

        Room presidentSuite = new Room(1, "President's suite", RoomType.SUITE, 2);
        Room singleRegular = new Room(2, "SingleRegular", RoomType.REGULAR, 1);
        Room doubleRegular = new Room(3, "Double Regular", RoomType.REGULAR, 2);
        Room empressSuite = new Room(4, "Empress's suite", RoomType.SUITE, 1);

        hotel.addRoom(presidentSuite);
        hotel.addRoom(singleRegular);
        hotel.addRoom(doubleRegular);
        hotel.addRoom(empressSuite);

        System.out.println(hotel.getRoomList());

        hotel.bookRoom(presidentSuite);
        System.out.println(presidentSuite.isBooked()); // true

        try {
            hotel.cancelBooking(presidentSuite); // throws an SuiteBookingCancellingException
        } catch (SuiteBookingCancellingException e) {
            System.out.println(e);
        }


        System.out.println(hotel.getRoomsBySize(1)); // single regular, empress suite

    }


}
