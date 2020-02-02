package DAO;

import interfaces.CarInterface;
import model.Car;
import model.Cash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.sql.Insert;
import util.DBHelper;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CarDao implements CarInterface {

    private SessionFactory sessionFactory;

    public CarDao() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    @Override
    public Car buyCar(String brand, String model, String licensePlate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Car> query = session.createQuery("SELECT  c From Car c " +
                "where c.brand = :brand " +
                "and c.model = :model " +
                "and  c.licensePlate = :licensePlate", Car.class);
        query.setParameter("brand", brand);
        query.setParameter("model", model);
        query.setParameter("licensePlate", licensePlate);
        List<Car> list = query.list();
        if (list.isEmpty()) {
            return null;
        }

        Car car = list.get(0);

        session.delete(car);
//        sqlQuery.setParameter("price", car.getPrice());
        transaction.commit();
        session.close();
        return car;
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
    public void addCar(Car car) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int count = getAllCars().size();

        if (count > 9) {
            transaction.rollback();
            throw new SQLException("Auto not added");
        } else {
            session.save(car);
            transaction.commit();
        }


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
    public void deleteAllCars() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
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
//
//    public void createTable() throws SQLException {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.createSQLQuery("create table if not exists Car (id bigint auto_increment, name varchar(256), password varchar(256), money bigint, primary key (id))");
//        transaction.commit();
//        session.close();
//    }
////
//    public void dropTable() throws SQLException {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.createSQLQuery("DROP TABLE IF EXISTS cars");
//        transaction.commit();
//        session.close();
//    }

}
