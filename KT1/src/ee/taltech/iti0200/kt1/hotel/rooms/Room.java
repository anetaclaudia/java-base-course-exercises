package ee.taltech.iti0200.kt1.hotel.rooms;


public class Room {
    private int roomId;
    private String name;
    private RoomType type;
    private int sleepingPlaces;
    private boolean isBooked;

    public Room(int roomId, String name, RoomType type, int sleepingPlaces) {
        this.roomId = roomId;
        this.name = name;
        this.type = type;
        this.sleepingPlaces = sleepingPlaces;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getSleepingPlaces() {
        return sleepingPlaces;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
}
