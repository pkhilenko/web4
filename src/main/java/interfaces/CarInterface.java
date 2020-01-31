package interfaces;

import model.Car;

import java.util.List;

public interface CarInterface {
    Car FindCar(int id);

    void saveCar(Car car);

    void deleteCar(Car car);

    void updateCar(Car car);

    List<Car> getAllCars();
}
