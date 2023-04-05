package mate.controller;

import mate.lib.Injector;
import mate.model.Driver;
import mate.service.DriverService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private final DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/cars/drivers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Driver newDriver = new Driver();
        newDriver.setName(req.getParameter("driver_name"));
        newDriver.setLicenseNumber(req.getParameter("license_number"));
        driverService.create(newDriver);
    }
}