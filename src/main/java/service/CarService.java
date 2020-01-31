package service;

import DAO.CarDao;
import interfaces.CarInterface;
import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class CarService implements CarInterface {

    private static CarService carService;
    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    CarDao carDao = getCarDao();

    private CarDao getCarDao() {
        return new CarDao();
    }

    @Override
    public Car FindCar(int id) {
        return carDao.findById(id);
    }

    @Override
    public void saveCar(Car car) {
        carDao.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carDao.delete(car);
    }

    @Override
    public void updateCar(Car car) {
        carDao.update(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCar();
    }

}