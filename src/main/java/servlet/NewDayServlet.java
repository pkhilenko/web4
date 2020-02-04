package servlet;

import com.google.gson.Gson;
import model.Car;
import model.DailyReport;
import service.CarService;
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

        List<Car> soldCars = CarService.getInstance().getSoldCars();
        int count = soldCars.size();
        Long total = 0L;

        DailyReport dailyReport;
        if (count == 0) {
            dailyReport = new DailyReport(0L, 0L);
        } else {
            total = soldCars.stream().map(car -> car.getPrice()).reduce((sum, price) -> sum + price).orElse(0L);
            dailyReport = new DailyReport(total, (long) count);

        }

        DailyReportService.getInstance().saveDailyReport(dailyReport);
        CarService.getInstance().deleteSoldcars();
        resp.setStatus(HttpServletResponse.SC_OK);
        json = gson.toJson("new day");
        resp.getWriter().println(json);
    }
}
