package servlet;

import com.google.gson.Gson;
import model.Car;
import service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProducerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String json = "";
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String licensePlate = req.getParameter("licensePlate");
        Long price = null;
        boolean sold = false;

        try {
            price = Long.parseLong(req.getParameter("price"), 10);
            System.out.println(price);
        } catch (NumberFormatException ignored) {
        }
        try {
            CarService.getInstance().addCar(new Car(brand, model, licensePlate, price));
            resp.setStatus(HttpServletResponse.SC_OK);
            json = gson.toJson("The transaction was successful");
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            json = gson.toJson("transaction rejected");
            e.printStackTrace();
        }

        resp.getWriter().println(json);
    }
}
