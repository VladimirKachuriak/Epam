package ua.advanced.practice8;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
}
