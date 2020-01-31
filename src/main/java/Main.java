import model.Car;
import model.DailyReport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.CarService;
import service.DailyReportService;
import util.DBHelper;

public class Main {

    public static void main(String[] args) {
//        SessionFactory sessionFactory = DBHelper.getSessionFactory();
//        Session session = sessionFactory.openSession();
        CarService carService = CarService.getInstance();
        DailyReportService dailyReport = DailyReportService.getInstance();

        Car car1 = new Car("aaaaq", "yaaaa", "jdddd", 126L);
        Car car2 = new Car("aaaaw", "uaaaa", "hgdddd", 127L);
        Car car13 = new Car("eaaaa", "uuaaaa", "gdddd", 128L);
        Car car4 = new Car("raaaa", "iaaaa", "fdddd", 129L);
        Car car5 = new Car("taaaa", "oaaaa", "ddddd", 1256L);
        Car car6 = new Car("yaaaa", "kaaaa", "ffdddd", 1243L);

        carService.saveCar(car1);
        carService.saveCar(car2);
        carService.saveCar(car13);
        carService.saveCar(car4);
        carService.saveCar(car5);
        carService.saveCar(car6);

        dailyReport.saveDailyReport(new DailyReport(3123L, 67345L));
        dailyReport.saveDailyReport(new DailyReport(4123L, 7889345L));
        dailyReport.saveDailyReport(new DailyReport(5123L, 34675L));
        dailyReport.saveDailyReport(new DailyReport(6123L, 334545L));
        dailyReport.saveDailyReport(new DailyReport(7123L, 378945L));
        dailyReport.saveDailyReport(new DailyReport(1823L, 634785L));
        System.out.println(dailyReport.getLastReport().getId() + " " + dailyReport.getLastReport().getSoldCars() );
//
//        session.beginTransaction();
//
//        session.getTransaction().commit();
    }
}
