import model.Car;
import model.DailyReport;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.CarService;
import service.DailyReportService;
import servlet.CustomerServlet;
import servlet.DailyReportServlet;
import servlet.NewDayServlet;
import servlet.ProducerServlet;
import util.DBHelper;

public class Main {

    public static void main(String[] args) throws Exception {

        CustomerServlet customerServlet = new CustomerServlet();
        ProducerServlet producerServlet = new ProducerServlet();
        NewDayServlet newDayServlet = new NewDayServlet();
        DailyReportServlet dailyReportServlet = new DailyReportServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(customerServlet), "/customer");
        context.addServlet(new ServletHolder(producerServlet), "/producer");
        context.addServlet(new ServletHolder(newDayServlet), "/newday");
        context.addServlet(new ServletHolder(dailyReportServlet), "/report/last");
        context.addServlet(new ServletHolder(dailyReportServlet), "/report/all");
        context.addServlet(new ServletHolder(dailyReportServlet), "/report");

        CarService carService = CarService.getInstance();
        DailyReportService dailyReport = DailyReportService.getInstance();

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
