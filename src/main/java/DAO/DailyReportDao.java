package DAO;

import model.DailyReport;
import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DailyReportDao {

    private Session session;

    public DailyReportDao(Session session) {
        this.session = session;
    }

    public DailyReport findById(int id) {
        return (DailyReport) session.get(DailyReport.class, id);
    }

    public void save(DailyReport dailyReport) {
        Transaction transaction = session.beginTransaction();
        session.save(dailyReport);
        transaction.commit();
        session.close();
    }

    public void update(DailyReport dailyReport) {
        Transaction transaction = session.beginTransaction();
        session.update(dailyReport);
        transaction.commit();
        session.close();
    }

    public void delete(DailyReport dailyReport) {
        Transaction transaction = session.beginTransaction();
        session.delete(dailyReport);
        transaction.commit();
        session.close();
    }

    public List<DailyReport> getAllDailyReport() {
        Transaction transaction = session.beginTransaction();
        List<DailyReport> dailyReports = session.createQuery("FROM DailyReport").list();
        transaction.commit();
        session.close();
        return dailyReports;
    }
}
