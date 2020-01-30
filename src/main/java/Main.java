import model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.CarService;
import util.DBHelper;

public class Main {

    public static void main(String[] args) {
//        SessionFactory sessionFactory = DBHelper.getSessionFactory();
//        Session session = sessionFactory.openSession();
        CarService carService = CarService.getInstance();

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
//
//        session.beginTransaction();
//
//        session.getTransaction().commit();
    }
}
