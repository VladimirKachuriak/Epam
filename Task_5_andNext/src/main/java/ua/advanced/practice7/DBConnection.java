package ua.advanced.practice7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private DBConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String url = resource.getString("db.url");
        connection = DriverManager.getConnection(url,user,pass);
    }
    public Connection getConnection(){
        return connection;
    }
    public static DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnection();
        }else if(instance.getConnection().isClosed()){
            instance = new DBConnection();
        }
        return instance;
    }
}
