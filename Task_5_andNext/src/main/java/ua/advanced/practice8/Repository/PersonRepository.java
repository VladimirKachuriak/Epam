package ua.advanced.practice8.Repository;

import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.Entity.Person;

import java.util.List;

public interface PersonRepository {
    boolean addPerson(Person person);
    boolean deletePerson(Person person);
    boolean updatePerson(Person person);
    Person getPerson(int num);
    List<Person> findAll();
}
