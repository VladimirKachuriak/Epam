package ua.advanced.practice8.Repository;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.advanced.practice6.observer.Repository;
import ua.advanced.practice8.BasicConnectionPool;
import ua.advanced.practice8.ConnectionPool;
import ua.advanced.practice8.Entity.Film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryImplTest {
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
    void addFilm() throws ParseException, SQLException {
        Connection connection = connectionPool.getConnection();
        FilmRepositoryImpl filmRepository = new FilmRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(true,filmRepository.addFilm(new Film("Titanic",
                new Date(dateFormat.parse("1999-01-21").getTime()),"USA")));
        assertEquals(false,filmRepository.addFilm(new Film("Titanic",
                new Date(dateFormat.parse("1999-01-21").getTime()),"USA")));
        connectionPool.releaseConnection(connection);
    }

    @Test
    void deleteFilm() throws ParseException {
        Connection connection = connectionPool.getConnection();
        FilmRepositoryImpl filmRepository = new FilmRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(true,filmRepository.deleteFilm(new Film("Matrix", new Date(dateFormat.parse("1999-01-01").getTime()),"USA")));
        assertEquals(false,filmRepository.deleteFilm(new Film("Matrix", new Date(dateFormat.parse("1999-01-01").getTime()),"USA")));
        connectionPool.releaseConnection(connection);
    }

    @Test
    void updateFilm() throws ParseException {
        Connection connection = connectionPool.getConnection();
        FilmRepositoryImpl filmRepository = new FilmRepositoryImpl(connection);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertTrue(filmRepository.updateFilm(new Film("Matrix", new Date(dateFormat.parse("2007-01-01").getTime()), "USA")));
        assertEquals(("Film{filmName='Matrix', date=2007-01-01, country='USA'}"), filmRepository.findFilm("Matrix").toString());
        connectionPool.releaseConnection(connection);
    }

    @Test
    void getAllFilms() throws ParseException {
        Connection connection = connectionPool.getConnection();
        FilmRepositoryImpl filmRepository = new FilmRepositoryImpl(connection);
        assertEquals("[Film{filmName='Avatar', date=2009-05-04, country='France'}, Film{filmName='Avatar2', date=2021-11-21, country='USA'}, Film{filmName='Matrix', date=1999-01-01, country='USA'}, Film{filmName='Matrix2', date=2003-05-04, country='Canada'}]",filmRepository.getAllFilms().toString());
        connectionPool.releaseConnection(connection);
    }
}