package DAO;

import model.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarDao {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    public Car findById(int id) {
        return (Car) session.get(Car.class, id);
    }

    public void save(Car car) {
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
//        session.close();
    }

    public void update(Car car) {
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    public void delete(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    public List<Car> getAllCar() {
        Transaction transaction = session.beginTransaction();
        List<Car> cars = (List<Car>) session.createQuery("From Car").list();
        transaction.commit();
        session.close();
        return cars;
    }

}
