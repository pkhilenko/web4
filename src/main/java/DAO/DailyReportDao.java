package DAO;

import model.DailyReport;
import model.DailyReport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class DailyReportDao {

    private SessionFactory sessionFactory;

    public DailyReportDao() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }

    public DailyReport findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DailyReport dailyReport = session.get(DailyReport.class, id);
        transaction.commit();
        session.close();
        return dailyReport;
    }

    public void save(DailyReport dailyReport) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dailyReport);
        transaction.commit();
        session.close();
    }

    public void update(DailyReport dailyReport) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(dailyReport);
        transaction.commit();
        session.close();
    }

    public void delete(DailyReport dailyReport) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(dailyReport);
        transaction.commit();
        session.close();
    }

    public List<DailyReport> getAllDailyReport() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        transaction.commit();
        session.close();
        return dailyReports;
    }

    public  DailyReport getLastReport() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        List<DailyReport> lastDailyReport = session.createQuery("FROM DailyReport order by id").list();
        List<DailyReport> lastDailyReport = session.createQuery("FROM DailyReport where id = (select max(id) FROM DailyReport)").list();
//        List<DailyReport> lastDailyReport = session.createNativeQuery("Select * from daily_reports where id=(select max(id) from daily_reports)", DailyReport.class).getResultList();

        transaction.commit();
        session.close();
        return lastDailyReport.get(lastDailyReport.size() - 1);
    }
}
