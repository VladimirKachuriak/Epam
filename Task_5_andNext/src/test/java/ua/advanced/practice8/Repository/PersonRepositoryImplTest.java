package ua.advanced.practice8.Repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.advanced.practice8.BasicConnectionPool;
import ua.advanced.practice8.ConnectionPool;
import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.Entity.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {
    private static ConnectionPool connectionPool;

    @BeforeAll
    public static void  init() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String url = resource.getString("db.url2");
        connectionPool = BasicConnectionPool.create(url, user, pass);
    }
    @Test
    void addPerson() throws ParseException {
        Connection connection = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(true,personRepository.addPerson(new Person("Jackson",
                "Michael","Joseph", new Date(dateFormat.parse("1999-05-21").getTime()))));

        connectionPool.releaseConnection(connection);
    }

    @Test
    void deletePerson() throws ParseException {
        Connection connection = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(true,personRepository.deletePerson(new Person("Pitt",
                "Brad","William", new Date(dateFormat.parse("1999-05-21").getTime()))));

        connectionPool.releaseConnection(connection);
    }

    @Test
    void updatePerson() throws ParseException {
        Connection connection = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(true,personRepository.updatePerson(new Person("Pitt",
                "Brad","William", new Date(dateFormat.parse("2007-05-21").getTime()))));

        connectionPool.releaseConnection(connection);
    }

    @Test
    void getPerson() {
        Connection connection = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("Person{surname='charles', name='Keanu', patronymic='Reves', personFunction=null}",personRepository.getPerson(2).toString());

        connectionPool.releaseConnection(connection);
    }

    @Test
    void findAll() {
        Connection connection = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(5,personRepository.findAll().size());

        connectionPool.releaseConnection(connection);
    }
}