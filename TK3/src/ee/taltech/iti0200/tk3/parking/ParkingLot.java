package ee.taltech.iti0200.tk3.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    int size;
    List<Car> cars = new ArrayList<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public boolean doesCarFit(Car car) {
        if (car.getSize() <= size && cars.isEmpty()) {
            return true;
        }
        int currentSize = cars.stream().mapToInt(Car::getSize).sum();
        return currentSize + car.getSize() <= size;
    }

    public boolean parkCar(Car car) {
        if (car.getSize() > 0 && !cars.contains(car) && doesCarFit(car)) {
            this.cars.add(car);
            return true;
        }
        return false;
    }

    public Optional<Car> unpark(String model) {
        Optional<Car> optionalCar = cars.stream().filter(car -> car.getModel().equals(model)).findFirst();
        if (optionalCar.isPresent()) {
            cars.remove(optionalCar.get());
            return optionalCar;
        }
        return Optional.empty();
    }

    public List<Car> getCars() {
        return cars;
    }

}
