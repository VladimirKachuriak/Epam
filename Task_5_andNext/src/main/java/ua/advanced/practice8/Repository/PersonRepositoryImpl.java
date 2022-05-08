package ua.advanced.practice8.Repository;

import ua.advanced.practice8.Entity.Person;
import ua.advanced.practice8.EntityDAO.ParticipantDAO;
import ua.advanced.practice8.EntityDAO.PersonDAO;

import java.sql.Connection;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository{
    private Connection connection;
    private PersonDAO personDAO;
    private ParticipantDAO participantDAO;

    public PersonRepositoryImpl(Connection connection) {
        this.connection = connection;
        participantDAO = new ParticipantDAO(connection);
        personDAO = new PersonDAO(connection);
    }

    @Override
    public boolean addPerson(Person person) {
        if(!personDAO.findAll().contains(person)){
            personDAO.create(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        if(personDAO.findAll().contains(person)){
            Person temp = personDAO.findAll().stream().filter(x->x.equals(person)).findFirst().get();
            participantDAO.deletePerson(temp.getId());
            personDAO.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
        if(personDAO.findAll().contains(person)){
            Person temp = personDAO.findAll().stream().filter(x->x.equals(person)).findFirst().get();
            temp.setBirthdate(person.getBirthdate());
            personDAO.update(temp);
            return true;
        }
        return false;
    }

    @Override
    public Person getPerson(int num) {
        return personDAO.read(num);
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }
}
