package ua.advanced.practice8.EntityDAO;

import ua.advanced.practice8.Entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements DAO<Person, Integer> {
    private final Connection connection;
    private static final String INSERT_PERSON= "INSERT INTO practice8.persons (name, surname, patronymic, birthdate)" +
            "VALUES (?, ?, ?, ?);";
    private static final String GET_PERSON= "SELECT persons.surname,persons.name, persons.patronymic, persons.birthdate FROM persons WHERE persons.id = (?);";
    private static final String GET_ALL_PERSON= "SELECT persons.id,persons.surname,persons.name, persons.patronymic, persons.birthdate FROM persons;";
    private static final String UPDATE_PERSON= "UPDATE persons SET surname = (?),name = (?), patronymic = (?), birthdate = (?) WHERE id = (?);";
    private static final String DELETE_PERSON= "DELETE FROM practice8.persons WHERE id = (?);";

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PERSON)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Person person =new Person(rs.getString("surname"),rs.getString("name"),rs.getString("patronymic"),rs.getDate("birthdate"));
                person.setId(rs.getInt("id"));
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
        return persons;
    }

    @Override
    public void create(Person model) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PERSON)) {
            statement.setString(1, model.getName());
            statement.setString(2, model.getSurname());
            statement.setString(3,model.getPatronymic());
            statement.setDate(4,model.getBirthdate());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    @Override
    public Person read(Integer integer) {
        Person person = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_PERSON)) {
            statement.setInt(1,integer);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                person = new Person(rs.getString("surname"),rs.getString("name"),rs.getString("patronymic"),rs.getDate("birthdate"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
        return person;
    }


    @Override
    public void update(Person model) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PERSON)) {
            statement.setString(1,model.getSurname());
            statement.setString(2,model.getName());
            statement.setString(3,model.getPatronymic());
            statement.setDate(4,model.getBirthdate());
            statement.setInt(5,model.getId());
            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }

    @Override
    public void delete(Person model) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PERSON)) {
            statement.setInt(1,model.getId());
            statement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO();
        }
    }
}
