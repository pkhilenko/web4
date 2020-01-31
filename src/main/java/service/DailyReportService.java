package service;

import DAO.DailyReportDao;
import interfaces.DailyReportInterface;
import model.DailyReport;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class DailyReportService implements DailyReportInterface {

    private static DailyReportService dailyReportService;

    public static DailyReportService getInstance() {
        if (dailyReportService == null) {
            dailyReportService = new DailyReportService();
        }
        return dailyReportService;
    }
    DailyReportDao dailyReportDao = null;

    DailyReportDao dao = getDailyReportDao();

    private DailyReportDao getDailyReportDao() {
        if (dailyReportDao == null) {
            dailyReportDao = new DailyReportDao();
        }
        return dailyReportDao;
    }

    @Override
    public DailyReport FindDailyReport(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveDailyReport(DailyReport dailyReport) {
        dao.save(dailyReport);
    }

    @Override
    public void deleteDailyReport(DailyReport dailyReport) {
        dao.delete(dailyReport);
    }

    @Override
    public void updateDailyReport(DailyReport dailyReport) {
        dao.update(dailyReport);
    }

    @Override
    public List<DailyReport> getAllDailyReports() {
        return dao.getAllDailyReport();
    }


    @Override
    public DailyReport getLastReport() {
        return dao.getLastReport();
    }
}
