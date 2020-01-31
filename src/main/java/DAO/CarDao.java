package DAO;

import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CarDao {

    private SessionFactory sessionFactory = DBHelper.getSessionFactory();

//    public CarDao(SessionFactory SessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public Car findById(int id) {
        Session session = sessionFactory.openSession();
        return (Car) session.get(Car.class, id);
    }

    public void save(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    public void update(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    public void delete(Car car) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    public List<Car> getAllCar() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> cars = (List<Car>) session.createQuery("From Car").list();
        transaction.commit();
        session.close();
        return cars;
    }

}
