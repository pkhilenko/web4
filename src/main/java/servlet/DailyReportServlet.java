package servlet;

import com.google.gson.Gson;
import model.DailyReport;
import service.CarService;
import service.DailyReportService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DailyReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json;

        if (req.getPathInfo().contains("all")) {
            json = gson.toJson(DailyReportService.getInstance().getAllReport());
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(json);
        } else if (req.getPathInfo().contains("last")) {
            DailyReport lastReport = DailyReportService.getInstance().getLastReport();
            json = gson.toJson(lastReport);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DailyReportService.getInstance().deleteAllDailyReports();
        CarService.getInstance().deleteAllCars();
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
