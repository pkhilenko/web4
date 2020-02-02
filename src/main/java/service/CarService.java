package service;

import DAO.CarDao;
import interfaces.CarInterface;
import model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService implements CarInterface {

    private static CarService carService;

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    CarDao carDao = null;

    CarDao dao = getCarDao();

    private CarDao getCarDao() {
        if (carDao == null) {
            carDao = new CarDao();
        }
        return carDao;
    }

    @Override
    public Car buyCar(String brand, String model, String licensePlate) {
        return dao.buyCar(brand, model, licensePlate);
    }

    @Override
    public Car findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void addCar(Car car) throws SQLException {
        dao.addCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        dao.deleteCar(car);
    }

    @Override
    public void updateCar(Car car) {
        dao.updateCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getAllCars();
    }

    @Override
    public void deleteAllCars() {
        dao.deleteAllCars();
    }
//
//    public void cleanUp() throws SQLException {
//            dao.dropTable();
//    }
//
//    public void createTable() throws SQLException {
//            dao.createTable();
//    }
}