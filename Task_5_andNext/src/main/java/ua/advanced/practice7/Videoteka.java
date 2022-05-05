package ua.advanced.practice7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Videoteka {
    private Connection connection;
    private static final String GET_ALL_FILMS = "SELECT *FROM films WHERE date < (?)";
    private static final String GET_ALL_ACTORS_FROM_FILM = "SELECT persons.surname, persons.name, persons.patronymic, persons.date, transit.Type FROM persons,transit " +
            "WHERE  transit.person_id=persons.id AND (?) = transit.film_name AND transit.Type = 'Actor' ;";
    private static final String GET_ACTORS_WHICH_GOT_MORE_THEN_N_FILMS =
            "SELECT person_id,persons.surname,persons.name,persons.patronymic, " +
                    "COUNT(*) AS CNT FROM transit,persons " +
                    "WHERE Type = 'Actor' AND transit.person_id=persons.id   " +
                    "GROUP BY person_id HAVING COUNT(*)>=(?);";
    private static final String GET_ACTORS_WHICH_WAS_ONES_DIRECTOR =
            "SELECT persons.surname,persons.name,persons.patronymic,persons.date FROM persons,transit WHERE persons.id IN (SELECT persons.id FROM persons,transit" +
                    " WHERE Type = 'Director' AND transit.person_id=persons.id" +
                    " GROUP BY person_id HAVING COUNT(*)>=1) and persons.id = transit.person_id and transit.Type = 'Actor';";
    private static final String DELETE_FILM_FROM_TRANSIT =
            "DELETE FROM transit  WHERE transit.film_name IN (SELECT films.name FROM films WHERE date<(?));";


    private static final String DELETE_FILM_FROM_FILMS =
            "DELETE FROM films  WHERE date<(?)";

    public Film[] getAllFilms(int year) {
        List<Film> films = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_FILMS);
            ps.setString(1, year + 1 + "-00-00");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                films.add(new Film(rs.getString("name"), rs.getDate("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return films.toArray(new Film[0]);
    }

    public Person[] getActorsFromFilm(String filmName) {
        List<Person> actors = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_ACTORS_FROM_FILM);
            ps.setString(1, filmName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                actors.add(new Person(rs.getString("persons.surname"),
                        rs.getString("persons.name"), rs.getString("persons.patronymic"), Person.Type.Actor));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actors.toArray(new Person[0]);
    }

    public void getActorsWithNotLessFilmThen(int counter) {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ACTORS_WHICH_GOT_MORE_THEN_N_FILMS);
            ps.setInt(1, counter);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("persons.surname") + " " +
                        rs.getString("persons.name") + " " + rs.getString("persons.patronymic") +
                        " count:" + rs.getString("CNT"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getActorsWhichWasDirector() {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ACTORS_WHICH_WAS_ONES_DIRECTOR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("persons.surname") + " " +
                        rs.getString("persons.name") + " " + rs.getString("persons.patronymic") +
                        " " + rs.getString("date"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteFilmWithOlderThenNYear(int years) {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            Date currentDate = new Date(System.currentTimeMillis()- (long) years *1000*60*60*24*365-1000*60*60*24);
            connection.setAutoCommit(false);
            PreparedStatement ps1 = connection.prepareStatement(DELETE_FILM_FROM_TRANSIT);
            ps1.setDate(1,currentDate);
            PreparedStatement ps2 = connection.prepareStatement(DELETE_FILM_FROM_FILMS);
            ps2.setDate(1,currentDate);
            ps1.execute();
            ps2.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
