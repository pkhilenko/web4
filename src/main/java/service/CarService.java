package service;

import DAO.CarDao;
import DAO.CarDao;
import interfaces.CarInterface;
import model.Car;
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
    CarDao carDao = null;

    CarDao dao = getCarDao();

    private CarDao getCarDao() {
        if (carDao == null) {
            carDao = new CarDao();
        }
        return carDao;
    }

    @Override
    public Car findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveCar(Car car) {
        dao.saveCar(car);
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

}