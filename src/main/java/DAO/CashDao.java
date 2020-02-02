package DAO;

import model.Cash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class CashDao {
    private SessionFactory sessionFactory;

    public CashDao() {
        this.sessionFactory =  DBHelper.getSessionFactory();
    }

    public void add(Cash cash) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cash);
        transaction.commit();
        session.close();
    }
    public List<Cash> getAllCash() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Cash> cashes = session.createQuery("From Cash").list();
        transaction.commit();
        session.close();
        return cashes;
    }

    public void clearCash() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Cash> cash = getAllCash();
        cash.forEach(session::delete);
        transaction.commit();
        session.close();
    }
}
