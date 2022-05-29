package org.example.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarDAO {
    private static final String SQL_ADD_CAR = "INSERT INTO cars(brand,model,release_date,state,auto_class,price)" +
            "VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_CAR = "UPDATE cars SET brand = (?),model = (?),release_date = (?),state = (?),auto_class = (?),price = (?) WHERE id = (?);";
    private static final String SQL_GET_CAR_BY_ID = "SELECT *FROM cars WHERE id = ?;";
    private static final String SQL_GET_ALL_CAR = "SELECT *FROM cars";
    private static final String SQL_DELETE_CAR_BY_ID = "DELETE FROM cars WHERE id=(?);";
    public static boolean addCar(String brand, String model, Date release_date,  String auto_class, int price) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_ADD_CAR)) {
            pst.setString(1, brand);
            pst.setString(2, model);
            pst.setDate(3, new java.sql.Date(release_date.getTime()));
            pst.setString(4, "AVAIL");
            pst.setString(5, auto_class);
            pst.setInt(6, price);

            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static List<Car> getAll(){
        List<Car> cars = new ArrayList<>();
        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_CAR);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setReleaseDate(rs.getDate("release_date"));
                car.setState(Car.State.valueOf(rs.getString("state")));
                car.setAutoClass(Car.Class.valueOf(rs.getString("auto_class")));
                car.setPrice(rs.getInt("price"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().releaseConnection(con);
        };
        return cars;
    }
    public static boolean deleteCar(int id) {
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_DELETE_CAR_BY_ID)) {
            pst.setInt(1, id);
            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static boolean editCar(Car car){
        boolean result = false;

        Connection con = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE_CAR)) {
            pst.setString(1, car.getBrand());
            pst.setString(2, car.getModel());
            pst.setDate(3,  new java.sql.Date(car.getReleaseDate().getTime()));
            pst.setString(4, String.valueOf(car.getState()));
            pst.setString(5, String.valueOf(car.getAutoClass()));
            pst.setInt(6, car.getPrice());
            pst.setInt(7, car.getId());
            result = pst.executeUpdate()>0;
            ConnectionPool.getInstance().releaseConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static Car getCarById(int id) {
        Car car = null;

        Connection con = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(SQL_GET_CAR_BY_ID);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                car = new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setReleaseDate(rs.getDate("release_date"));
                car.setState(Car.State.valueOf(rs.getString("state")));
                car.setAutoClass(Car.Class.valueOf(rs.getString("auto_class")));
                car.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.getInstance().releaseConnection(con);
        };
        return car;
    }
}
