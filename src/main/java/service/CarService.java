package service;

import DAO.CarDao;
import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class CarService {

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

    CarDao carDao = getCarDao();

    private CarDao getCarDao() {
        return new CarDao(DBHelper.getSessionFactory().openSession());
    }

    public Car FindCar(int id) {
        return carDao.findById(id);
    }
    public void saveCar(Car car) {
        carDao.save(car);
    }
    public void deleteCar(Car car) {
        carDao.delete(car);
    }
    public void updateCar(Car car) {
        carDao.update(car);
    }
    public List<Car> getAllCars() {
        return carDao.getAllCar();
    }

}