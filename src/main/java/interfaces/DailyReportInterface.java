package interfaces;

import model.DailyReport;

import java.util.List;

public interface DailyReportInterface {
    DailyReport FindDailyReport(int id);

    void saveDailyReport(DailyReport dailyReport);

    void deleteDailyReport(DailyReport dailyReport);

    void updateDailyReport(DailyReport dailyReport);

    List<DailyReport> getAllReport();

    DailyReport getLastReport();
}
