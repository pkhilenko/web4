package service;

import DAO.CarDao;
import interfaces.CarInterface;
import model.Car;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class CarService implements CarInterface {

    private static CarService carService;

    private SessionFactory sessionFactory;

    public CarService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService(DBHelper.getSessionFactory());
        }
        return carService;
    }

    @Override
    public Car findById(int id) {
        CarDao carDao = new CarDao(sessionFactory.openSession());
        return carDao.findById(id);
    }

    @Override
    public void saveCar(Car car) {
        CarDao carDao = new CarDao(sessionFactory.openSession());
        carDao.saveCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        CarDao carDao = new CarDao(sessionFactory.openSession());
        carDao.deleteCar(car);
    }

    @Override
    public void updateCar(Car car) {
        CarDao carDao = new CarDao(sessionFactory.openSession());
        carDao.updateCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        CarDao carDao = new CarDao(sessionFactory.openSession());
        return carDao.getAllCars();
    }

}