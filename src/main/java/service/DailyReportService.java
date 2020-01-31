package service;

import DAO.DailyReportDao;
import interfaces.DailyReportInterface;
import model.DailyReport;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class DailyReportService implements DailyReportInterface {

    private static DailyReportService dailyReportService;

    private SessionFactory sessionFactory;

    private DailyReportService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static DailyReportService getInstance() {
        if (dailyReportService == null) {
            dailyReportService = new DailyReportService(DBHelper.getSessionFactory());
        }
        return dailyReportService;
    }

    @Override
    public DailyReport FindDailyReport(int id) {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        return dao.findById(id);
    }

    @Override
    public void saveDailyReport(DailyReport dailyReport) {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        dao.save(dailyReport);
    }

    @Override
    public void deleteDailyReport(DailyReport dailyReport) {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        dao.delete(dailyReport);
    }

    @Override
    public void updateDailyReport(DailyReport dailyReport) {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        dao.update(dailyReport);
    }

    @Override
    public List<DailyReport> getAllDailyReports() {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        return dao.getAllDailyReport();
    }


    @Override
    public DailyReport getLastReport() {
        DailyReportDao dao = new DailyReportDao(sessionFactory.openSession());
        return dao.getLastReport();
    }
}
