package ua.advanced.practice8.EntityDAO;

import ua.advanced.practice8.Entity.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements DAO<Film, String> {
    private final Connection connection;
    private static final String INSERT_FILM= "INSERT INTO practice8.films (name, releaseDate, releaseCountry)" +
            "VALUES (?, ?, ?);";
    private static final String GET_ALL_FILM= "SELECT films.name,films.releaseDate, releaseCountry FROM films";
    private static final String GET_FILM= "SELECT films.name,films.releaseDate, releaseCountry FROM films WHERE films.name = (?)";
    private static final String UPDATE_FILM= "UPDATE films SET releaseDate = (?),releaseCountry = (?) WHERE name = (?)";
    private static final String DELETE_FILM= "DELETE FROM practice8.films WHERE name = (?);";
    public FilmDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_FILM)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                films.add(new Film(rs.getString("name"),rs.getDate("releaseDate"),rs.getString("releaseCountry")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
        return films;
    }

    @Override
    public void create(Film model) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_FILM)) {
            statement.setString(1, model.getFilmName());
            statement.setDate(2, model.getDate());
            statement.setString(3,model.getCountry());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    @Override
    public Film read(String s) {
        Film film = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_FILM)) {
            statement.setString(1,s);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                film = new Film(rs.getString("name"),rs.getDate("releaseDate"),rs.getString("releaseCountry"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
        return film;
    }

    @Override
    public void update(Film model) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_FILM)) {
            statement.setDate(1,model.getDate());
            statement.setString(2,model.getCountry());
            statement.setString(3,model.getFilmName());
            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    @Override
    public void delete(Film model) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_FILM)) {
            statement.setString(1,model.getFilmName());
            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

}
