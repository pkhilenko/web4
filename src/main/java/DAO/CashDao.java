package DAO;

import model.Cash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;


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
}
