package servlet;

import com.google.gson.Gson;
import model.Cash;
import model.DailyReport;
import service.CashService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NewDayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json;

        List<Cash> allCash = CashService.getInstance().getAllCash();
        int count = allCash.size();
        DailyReport dailyReport;
        if (count == 0) {
            dailyReport = new DailyReport(0L, 0L);
        } else {
            Long[] total = {0L};
            allCash.forEach(cash -> total[0] += cash.getPrice());
            dailyReport = new DailyReport(total[0], (long) count);
        }

        DailyReportService.getInstance().saveDailyReport(dailyReport);
        CashService.getInstance().clearCash();
        resp.setStatus(HttpServletResponse.SC_OK);
        json = gson.toJson("new day");
        resp.getWriter().println(json);
    }
}
