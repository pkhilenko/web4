package interfaces;

import model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarInterface {
    Car findById(int id);

    Car buyCar(String brand, String model, String licensePlate);

    void addCar(Car car) throws SQLException;

    void deleteCar(Car car);

    void deleteAllCars();

    void updateCar(Car car);

    List<Car> getAllCars();
}
