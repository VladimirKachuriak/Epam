package ua.advanced.practice8.EntityDAO;

import ua.advanced.practice8.Entity.Participant;
import ua.advanced.practice8.Entity.Person;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private final Connection connection;

    private static final String INSERT_PARTICIPANT = "INSERT INTO practice8.participants (film_name, person_id, type)" +
            "VALUES (?, ?, ?);";
    private static final String GET_ALL_PARTICIPANT = "SELECT film_name, person_id, type FROM participants;";
    private static final String DELETE_PARTICIPANT = "DELETE FROM practice8.participants WHERE film_name = (?) AND person_id = (?) AND type = (?);";
    private static final String DELETE_PARTICIPANT_BY_FILM = "DELETE FROM practice8.participants WHERE film_name = (?) ;";
    private static final String DELETE_PARTICIPANT_BY_PERSON_ID = "DELETE FROM practice8.participants WHERE person_id = (?) ;";

    public ParticipantDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PARTICIPANT)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Person.Type type;
                if(rs.getString("type").equals("Actor")){
                      type = Person.Type.Actor;
                }else{
                    type = Person.Type.Director;
                }
                participants.add(new Participant(rs.getString("film_name"),rs.getInt("person_id"),type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
        return participants;
    }

    public void create(Participant model) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PARTICIPANT)) {
            statement.setString(1, model.getFilmName());
            statement.setInt(2, model.getPerson_id());
            statement.setString(3, model.getType());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    public void deleteModel(Participant model) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PARTICIPANT)) {
            statement.setString(1, model.getFilmName());
            statement.setInt(2, model.getPerson_id());
            statement.setString(3, model.getType());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    public void deleteFilm(String filmName) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PARTICIPANT_BY_FILM)) {
            statement.setString(1, filmName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }
    public void deletePerson(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PARTICIPANT_BY_PERSON_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }
}
