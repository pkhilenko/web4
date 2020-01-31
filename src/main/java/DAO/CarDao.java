package DAO;

import interfaces.CarInterface;
import model.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarDao implements CarInterface {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    @Override
    public Car findById(int id) {
        Transaction transaction = session.beginTransaction();
        Car car = session.get(Car.class, id);
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public void saveCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> getAllCars() {
        Transaction transaction = session.beginTransaction();
        List<Car> cars = (List<Car>) session.createQuery("From Car").list();
        transaction.commit();
        session.close();
        return cars;
    }

}
