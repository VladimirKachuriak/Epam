package org.example.Controller;

import org.apache.log4j.Logger;
import org.example.Model.User;
import org.example.Model.UserDAO;
import org.example.Service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(UserServlet.class.getSimpleName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardListUsers(req,resp, UserDAO.getAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "changeStatus":
                changeUserStatus(req, resp);
                break;
            case "addAdmin":
                 addAdminAction(req,resp);
        }
    }

    private void addAdminAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phone");
        User user = new User();
        user.setLogin(login);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setRole(User.Role.ADMIN);
        user.setStatus(User.Status.ACTIVE);
        if(!Validator.validatePhone(phoneNumber)){
            req.getSession().setAttribute("message","label.warning.incorrectPhone");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/new_admin.jsp").forward(req, resp);
            return;
        }
        if(!Validator.validateEmail(email)){
            req.getSession().setAttribute("message","label.warning.incorrectEmail");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/new_admin.jsp").forward(req, resp);
            return;
        }
        if(UserDAO.findUserByLogin(login)!=null){
            req.getSession().setAttribute("message","label.warning.userAlreadyExist");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/new_admin.jsp").forward(req, resp);
            return;
        }
        boolean flag = UserDAO.addUser(user);
        if(flag)resp.sendRedirect("users");
    }

    private void changeUserStatus(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("idUser"));
        User user = UserDAO.findUserById(id);
        if(user.getRole().equals(User.Role.ADMIN)){
            req.getSession().setAttribute("message","label.message.banAdmin");
            resp.sendRedirect("users");
            return;
        }
        if(user.getStatus()==User.Status.ACTIVE){
            log.info("user was banned");
            user.setStatus(User.Status.BANNED);
            req.getSession().setAttribute("message","label.message.userBanned");
        }else {
            log.info("user was unbanned");
            user.setStatus(User.Status.ACTIVE);
            req.getSession().setAttribute("message","label.message.userUnBanned");
        }
        UserDAO.updateUser(user);
        resp.sendRedirect("users");
    }

    private void forwardListUsers(HttpServletRequest req, HttpServletResponse resp, List<User> users)
            throws ServletException, IOException {
        log.info("return /list_user.jsp");
        String nextJSP = "/list_user.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", users);
        dispatcher.forward(req, resp);
    }
}
