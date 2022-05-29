package org.example.Controller;

import org.apache.log4j.Logger;
import org.example.Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userOrders")
public class UserOrderServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserOrderServlet.class.getSimpleName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.findUserByLogin((String) req.getSession().getAttribute("login"));
        int id = user.getId();
        req.setAttribute("profile",user);
        forwardListOrders(req,resp, OrderDAO.getAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "pay":
                makePayment(req, resp);
                break;
            case "topUpMoney":
                topUpAccount(req,resp);
                break;
        }
    }

    private void topUpAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user  = UserDAO.findUserByLogin(String.valueOf(req.getSession().getAttribute("login")));
        user.setAccount(user.getAccount()+Integer.parseInt(req.getParameter("money")));
        UserDAO.updateUser(user);
        req.getSession().setAttribute("message","label.message.topUpAccount");
        log.info("top up account");
        resp.sendRedirect("userOrders");
    }

    private void makePayment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
         int id = Integer.parseInt(req.getParameter("idOrder"));
        Order order = OrderDAO.getOrderById(id);
        int idUser  = order.getIdUser();
        User user  = UserDAO.findUserById(idUser);
        if(order.getState().equals(Order.State.WAIT)){
            if(user.getAccount()<order.getAccount()){
                req.getSession().setAttribute("message","label.message.notEnoughMoney");
                resp.sendRedirect("userOrders");
                return;
            }
            log.info("user paid for the order");
            user.setAccount(user.getAccount()-order.getAccount());
            UserDAO.updateUser(user);
            order.setState(Order.State.PAID);
            OrderDAO.updateOrder(order);
            resp.sendRedirect("userOrders");
            return;
        }
        if(order.getState().equals(Order.State.DAMAGED)){
            log.info("user paid for the damaged car");
            if(user.getAccount()<order.getAccountDamage()){
                req.getSession().setAttribute("message","label.message.notEnoughMoney");
                resp.sendRedirect("userOrders");
                return;
            }
            user.setAccount(user.getAccount()-order.getAccountDamage());
            UserDAO.updateUser(user);
            order.setState(Order.State.FINISH);
            OrderDAO.updateOrder(order);
            Car car = CarDAO.getCarById(order.getIdCar());
            car.setState(Car.State.AVAIL);
            CarDAO.editCar(car);
            resp.sendRedirect("userOrders");
            return;
        }
        if(order.getState().equals(Order.State.FINISH)||order.getState().equals(Order.State.RETURN)){
            req.getSession().setAttribute("message","label.message.yourOrderFinish");
            resp.sendRedirect("userOrders");
            return;
        }
        req.getSession().setAttribute("message","label.message.waitUntilAdminProcess");
        resp.sendRedirect("userOrders");
    }

    private void forwardListOrders(HttpServletRequest req, HttpServletResponse resp, List<Order> orders)
            throws ServletException, IOException {
        String nextJSP = "/user_orders.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("orderList", orders);
        dispatcher.forward(req, resp);
    }
}
