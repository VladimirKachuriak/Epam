package org.example.Model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final Logger log = Logger.getLogger(OrderDAO.class.getSimpleName());
    private static final String SQL_ADD_ORDER = "INSERT INTO orders(idCar, idUser, startDate, endDate, " +
            "withDriver, account, accountDamage, serial, expire, state, message)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE_ORDER = "UPDATE  orders SET idCar = (?), idUser = (?), startDate = (?), endDate = (?), " +
            "withDriver = (?), account = (?), accountDamage = (?), serial = (?), expire = (?), state = (?), message = (?)" +
            "WHERE id = (?);";
    public static final String SQL_GET_ALL_ORDER = "SELECT * FROM orders;";
    public static final String SQL_GET_ALL_ORDER_BY_CAR_ID = "SELECT * FROM orders WHERE idCar = (?);";
    public static final String SQL_GET_ORDER_BY_ID = "SELECT * FROM orders WHERE id = (?);";
    public static final String SQL_GET_ORDER_BY_USER_ID = "SELECT * FROM orders WHERE idUser = (?);";
    public static final String SQL_DELETE_ORDER_BY_CAR_ID = "DELETE FROM orders WHERE idCar = (?);";

    public static boolean addOrder(Order order) {
        boolean result = false;
        log.debug("get new order");
        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_ADD_ORDER)) {
            pst.setInt(1, order.getIdCar());
            pst.setInt(2, order.getIdUser());
            pst.setDate(3, new Date(order.getStart_date().getTime()));
            pst.setDate(4, new Date(order.getEnd_date().getTime()));
            pst.setBoolean(5, order.isWithDriver());
            pst.setInt(6, order.getAccount());
            pst.setInt(7, order.getAccountDamage());
            pst.setString(8, order.getPassportSerial());
            pst.setDate(9, new Date(order.getPassportExpireDate().getTime()));
            pst.setString(10, String.valueOf(order.getState()));
            pst.setString(11, order.getMessage());

            result = pst.executeUpdate() > 0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        }
        return result;
    }

    public static List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        log.debug("get all orders");
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_ORDER);
            ResultSet rs = pst.executeQuery();
            orders = getListRS(rs);
        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return orders;
    }
    public static boolean deleteOrderByCarId(int id) {
        log.debug("delete Order by car id");
        boolean result = false;
        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_DELETE_ORDER_BY_CAR_ID)) {
            pst.setInt(1, id);
            result = pst.executeUpdate()>0;
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        }finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return result;
    }
    public static List<Order> getAllByCarID() {
        log.debug("get all orders by car id");
        List<Order> orders = new ArrayList<>();
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_ORDER_BY_CAR_ID);
            ResultSet rs = pst.executeQuery();
            orders = getListRS(rs);
        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return orders;
    }

    public static Order getOrderById(int id) {
        Order order = null;
        log.debug("get order by  id");
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_ORDER_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            order = getOrderRS(rs);
        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return order;
    }

    public static List<Order> getOrdersByUserId(int id) {
        log.debug("get order by user id");
        List<Order> orders = new ArrayList<>();
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_ORDER_BY_USER_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            orders = getListRS(rs);
        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return orders;
    }

    private static List<Order> getListRS(ResultSet rs) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setIdUser(rs.getInt("idUser"));
            order.setIdCar(rs.getInt("idCar"));
            order.setStart_date(rs.getDate("startDate"));
            order.setEnd_date(rs.getDate("endDate"));
            order.setWithDriver(rs.getBoolean("withDriver"));
            order.setAccount(rs.getInt("account"));
            order.setAccountDamage(rs.getInt("accountDamage"));
            order.setPassportSerial(rs.getString("serial"));
            order.setPassportExpireDate(rs.getDate("expire"));
            order.setState(Order.State.valueOf(rs.getString("state")));
            order.setMessage(rs.getString("message"));
            orders.add(order);
        }
        return orders;
    }

    private static Order getOrderRS(ResultSet rs) throws SQLException {
        Order order = null;
        while (rs.next()) {
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setIdUser(rs.getInt("idUser"));
            order.setIdCar(rs.getInt("idCar"));
            order.setStart_date(rs.getDate("startDate"));
            order.setEnd_date(rs.getDate("endDate"));
            order.setWithDriver(rs.getBoolean("withDriver"));
            order.setAccount(rs.getInt("account"));
            order.setAccountDamage(rs.getInt("accountDamage"));
            order.setPassportSerial(rs.getString("serial"));
            order.setPassportExpireDate(rs.getDate("expire"));
            order.setState(Order.State.valueOf(rs.getString("state")));
            order.setMessage(rs.getString("message"));
        }
        return order;
    }

    public static boolean updateOrder(Order order) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE_ORDER)) {
            pst.setInt(1, order.getIdCar());
            pst.setInt(2, order.getIdUser());
            pst.setDate(3, new Date(order.getStart_date().getTime()));
            pst.setDate(4, new Date(order.getEnd_date().getTime()));
            pst.setBoolean(5, order.isWithDriver());
            pst.setInt(6, order.getAccount());
            pst.setInt(7, order.getAccountDamage());
            pst.setString(8, order.getPassportSerial());
            pst.setDate(9, new Date(order.getPassportExpireDate().getTime()));
            pst.setString(10, String.valueOf(order.getState()));
            pst.setString(11, order.getMessage());
            pst.setInt(12, order.getId());
            result = pst.executeUpdate() > 0;

            result = pst.executeUpdate() > 0;
            log.debug("update Order");
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        } finally {
            ConnectionPool.getInstance().releaseConnection(con);
        }
        return result;
    }
}
