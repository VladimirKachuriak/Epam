package org.example.Controller;

import org.example.Model.*;
import org.example.Service.CarService;
import org.example.Service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = filterCar(CarDAO.getAll(), req.getParameter("sort"), req.getParameter("order"), req.getParameter("brand"),req.getParameter("rate"));
        req.setAttribute("brands", CarService.getAllBrand(CarDAO.getAll()));

        int page = 1;
        int recordsPerPage = 5;
        if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
        int noOfRecords = cars.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        cars = CarService.diapasonCars(cars,(page-1)*recordsPerPage,(page-1)*recordsPerPage+recordsPerPage);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        forwardListCar(req, resp, cars);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("role") != User.Role.USER) {
            //System.out.println("ROLE:" + req.getSession().getAttribute("role"));
            resp.sendRedirect("login");
            return;
        }
        int userid = UserDAO.findUserByLogin((String) req.getSession().getAttribute("login")).getId();
        List<Order> orders = OrderDAO.getOrdersByUserId(userid);
        if (orders.stream().anyMatch(x -> (!x.getState().equals(Order.State.FINISH) && !x.getState().equals(Order.State.RETURN)))) {
            req.getSession().setAttribute("message", "label.order.notFinishRent");
            resp.sendRedirect("catalog");
            return;
        }
        int idCar = Integer.parseInt(req.getParameter("idCar"));
        String action = req.getParameter("action");
        switch (action) {
            case "makeOrder":
                req.setAttribute("idCar", idCar);
                getServletContext().getRequestDispatcher("/new_order.jsp").forward(req, resp);
                break;
            case "createOrder":
                makeOrder(req, resp);
                break;
        }

    }

    private List<Car> filterCar(List<Car> cars, String sort, String order, String model, String rate) {
        if (model != null && !model.equals("all")) {
            cars = CarService.filterModel(cars, model);
        }

        if (rate != null && !rate.equals("all")) {
            cars = CarService.filterAutoClass(cars, rate);
        }
        if (sort != null && sort.equals("price")) {
            cars = CarService.sortCarByPrice(cars);
        }
        if (sort != null && sort.equals("model")) {
            cars = CarService.sortCarByModel(cars);
        }
        if (order != null && order.equals("DESC")) {
            CarService.carDesc(cars);
        }
        return cars;
    }

    private void makeOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String serialNumber = req.getParameter("serial");
        String expireDate = req.getParameter("expire");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        Map<String, String> viewAttributes = new HashMap<>();
        req.setAttribute("idCar", req.getParameter("idCar"));
        viewAttributes.put("serialNumber", serialNumber);
        viewAttributes.put("expireDate", expireDate);
        viewAttributes.put("startDate", startDate);
        viewAttributes.put("endDate", endDate);
        try {
            Date expire = new SimpleDateFormat("yyyy-MM-dd").parse(expireDate);
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            if (!Validator.drivingLicence(serialNumber)) {
                viewAttributes.put("message", "label.warning.licence");
                passErrorToView(req, resp, viewAttributes);
                return;
            }
            if (expire.compareTo(end) < 0) {
                viewAttributes.put("message", "label.warning.expireDate");
                passErrorToView(req, resp, viewAttributes);
                return;
            }
            if (endDate.compareTo(startDate) <= 0) {
                viewAttributes.put("message", "label.warning.endDate");
                passErrorToView(req, resp, viewAttributes);
                return;
            }

            if (start.compareTo(new Date()) < 0) {
                viewAttributes.put("message", "label.warning.startDate");
                passErrorToView(req, resp, viewAttributes);
                return;
            }
            int countOfDay = (int) ((end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24));
            Order order = new Order();
            order.setIdUser(UserDAO.findUserByLogin((String) req.getSession().getAttribute("login")).getId());
            order.setIdCar(Integer.parseInt(req.getParameter("idCar")));
            order.setStart_date(start);
            order.setEnd_date(end);
            order.setPassportExpireDate(expire);
            order.setWithDriver(Boolean.parseBoolean(req.getParameter("check")));
            order.setState(Order.State.SEND);
            order.setPassportSerial(req.getParameter("serial"));
            if (order.isWithDriver()) {
                order.setAccount(countOfDay * (int) (CarDAO.getCarById(Integer.parseInt(req.getParameter("idCar"))).getPrice() * 1.5));
            } else {
                order.setAccount(countOfDay * (CarDAO.getCarById(Integer.parseInt(req.getParameter("idCar"))).getPrice()));
            }
            order.setAccountDamage(0);
            order.setMessage("");
            OrderDAO.addOrder(order);
            resp.sendRedirect("userOrders");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void forwardListCar(HttpServletRequest req, HttpServletResponse resp, List<Car> users)
            throws ServletException, IOException {
        String nextJSP = "/catalog.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("carList", users);
        dispatcher.forward(req, resp);
    }

    private void passErrorToView(HttpServletRequest request, HttpServletResponse response, Map<String, String> viewAttributes) throws ServletException, IOException {
        for (Map.Entry<String, String> entry : viewAttributes.entrySet())
            request.setAttribute(entry.getKey(), entry.getValue());
        request.getRequestDispatcher("new_order.jsp").forward(request, response);
    }
}
