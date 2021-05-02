package ee.taltech.iti0200.kt1.hotel;

import ee.taltech.iti0200.kt1.hotel.exceptions.AlreadyExistingRoomException;
import ee.taltech.iti0200.kt1.hotel.exceptions.NotExistingRoomException;
import ee.taltech.iti0200.kt1.hotel.exceptions.SuiteBookingCancellingException;
import ee.taltech.iti0200.kt1.hotel.rooms.Room;
import ee.taltech.iti0200.kt1.hotel.rooms.RoomType;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Hotel {
    String name;
    Set<Room> roomList = new HashSet<>();

    public Hotel(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        Set<Integer> roomListById = roomList.stream().map(Room::getRoomId).collect(Collectors.toSet());
        if (!roomListById.contains(room.getRoomId())) {
            roomList.add(room);
        } else {
            throw new AlreadyExistingRoomException();
        }
    }

    public void bookRoom(Room room) {
        if (roomList.contains(room)) {
            if (!room.isBooked()) {
                room.setBooked(true);
            }
        } else {
            throw new NotExistingRoomException();
        }
    }

    public void cancelBooking(Room room) {
        if (room.getType().equals(RoomType.REGULAR) && room.isBooked()) {
            room.setBooked(false);
        } else if (room.getType().equals(RoomType.SUITE)) {
            throw new SuiteBookingCancellingException();
        }
    }

    public Set<Room> getRoomList() {
        return roomList;
    }

    public Set<Room> getRoomsBySize(int size) {
        return roomList.stream().filter(room -> room.getSleepingPlaces() == size).collect(Collectors.toSet());
    }

    public Set<Room> getBookedRooms() {
        return roomList.stream().filter(Room::isBooked).collect(Collectors.toSet());
    }

}
