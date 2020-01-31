package DAO;

import interfaces.CarInterface;
import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarDao implements CarInterface {

    private SessionFactory sessionFactory;

    public CarDao() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    @Override
    public Car findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.get(Car.class, id);
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public void saveCar(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCar(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCar(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> getAllCars() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> cars = (List<Car>) session.createQuery("From Car").list();
        transaction.commit();
        session.close();
        return cars;
    }

}
