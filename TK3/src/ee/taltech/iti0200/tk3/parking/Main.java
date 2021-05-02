package ee.taltech.iti0200.tk3.parking;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        Car c0 = new Car("");
        Car c1 = new Car("Mersu", 1);
        Car c2 = new Car("BMW", 2);
        Car c3 = new Car("Audi", 3);
        Car c4 = new Car("Jeep", 4);
        Car c5 = new Car("Mazda");

        System.out.println(parkingLot.parkCar(c0)); // false
        System.out.println(parkingLot.parkCar(c1)); // true
        System.out.println(parkingLot.parkCar(c1)); // false
        System.out.println(parkingLot.parkCar(c2)); // true
        System.out.println(parkingLot.parkCar(c3)); // true
        System.out.println(parkingLot.parkCar(c4)); // true
        System.out.println(parkingLot.parkCar(c5)); // false

        System.out.println(parkingLot.unpark("Mersu").get()); // Mersu (1)
        System.out.println(parkingLot.unpark("Mersu")); // Optional.empty

        System.out.println(parkingLot.getCars()); // [BMW (2), Audi (3), Jeep (4)]
    }
}
