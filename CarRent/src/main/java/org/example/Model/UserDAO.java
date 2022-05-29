package org.example.Model;

import org.apache.log4j.Logger;
import org.example.Filter.EncodingFilter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final Logger log = Logger.getLogger(UserDAO.class.getSimpleName());
    private static final String SQL_ADD_USER = "INSERT INTO users(login,firstname,lastname,email,password,role,status,phone_number,account)" +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET login = (?),firstname = (?),lastname = (?),email = (?),password = (?),role = (?),status=(?),phone_number =(?),account=(?) WHERE id = (?);";
    public static final String FIND_ALL_USERS = "SELECT * FROM users;";
    public static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login = (?);";
    public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = (?);";
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = (?) AND password = (?);";
    public static final String BLOCK_USER_BY_ID = "UPDATE users SET status=? WHERE id=?;";

    public static boolean addUser(String login, String firstname, String lastname, String email, String password, String phoneNumber) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_ADD_USER)) {
            pst.setString(1, login);
            pst.setString(2, firstname);
            pst.setString(3, lastname);
            pst.setString(4, email);
            pst.setString(5, password);
            pst.setString(6, "USER");
            pst.setString(7, "ACTIVE");
            pst.setString(8, phoneNumber);
            pst.setInt(9, 0);

            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.fatal("UserDAO exception:"+ex);
        }
        return result;
    }
    public static boolean addUser(User user) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_ADD_USER)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getFirstName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.setString(6, user.getRole().toString());
            pst.setString(7, user.getStatus().toString());
            pst.setString(8, user.getPhoneNumber());
            pst.setInt(9, 0);

            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.fatal("UserDAO exception:"+ex);
        }
        return result;
    }
    public static boolean updateUser(User user) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE_USER)) {
            pst.setString(1, user.getLogin());
            pst.setString(2, user.getFirstName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getPassword());
            pst.setString(6, String.valueOf(user.getRole()));
            pst.setString(7, String.valueOf(user.getStatus()));
            pst.setString(8, user.getPhoneNumber());
            pst.setInt(9, user.getAccount());
            pst.setInt(10, user.getId());

            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.fatal("UserDAO exception:"+ex);
        }
        return result;
    }
    public static User findUserByLogin(String login) {
        User user = null;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(FIND_USER_BY_LOGIN)) {
            pst.setString(1, login);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(User.Role.valueOf(resultSet.getString("role")));
                user.setStatus(User.Status.valueOf(resultSet.getString("status")));
                user.setPhoneNumber(resultSet.getString("phone_number"));
                user.setAccount(resultSet.getInt("account"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.fatal("UserDAO exception:"+ex);
        }finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return user;
    }
    public static List<User> getAll(){
        List<User> users = new ArrayList<>();
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(FIND_ALL_USERS);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(User.Role.valueOf(rs.getString("role")));
                user.setStatus(User.Status.valueOf(rs.getString("status")));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setAccount(rs.getInt("account"));
                users.add(user);
            }
        } catch (SQLException e) {
            log.fatal("UserDAO exception:"+e);
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().releaseConnection(con);
        };
        return users;
    }

    public static User findUserById(int id) {
            User user = null;
            Connection con = ConnectionPool.getInstance().getConnection();
            try (PreparedStatement pst = con.prepareStatement(FIND_USER_BY_ID)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(User.Role.valueOf(resultSet.getString("role")));
                    user.setStatus(User.Status.valueOf(resultSet.getString("status")));
                    user.setPhoneNumber(resultSet.getString("phone_number"));
                    user.setAccount(resultSet.getInt("account"));
                }
            } catch (SQLException ex) {
                log.fatal("UserDAO exception:"+ex);
                ex.printStackTrace();
            }finally {
                ConnectionPool.getInstance().releaseConnection(con);
            }
            return user;

    }
}
