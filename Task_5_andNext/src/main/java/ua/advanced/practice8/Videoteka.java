package ua.advanced.practice8;


import ua.advanced.practice7.DBConnection;
import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.Entity.Participant;
import ua.advanced.practice8.Entity.Person;
import ua.advanced.practice8.Repository.FilmRepositoryImpl;
import ua.advanced.practice8.Repository.ParticipantRepositoryImpl;
import ua.advanced.practice8.Repository.PersonRepository;
import ua.advanced.practice8.Repository.PersonRepositoryImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Videoteka {
    private ConnectionPool connectionPool;
    private FilmRepositoryImpl filmRepository;

    public Videoteka() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String url = resource.getString("db.url2");
        connectionPool = BasicConnectionPool.create(url, user, pass);

    }

    public Person[] getActorsFromFilm(String filmName) {
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection1);
        ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl(connection2);
        List<Integer> actorsId = new ArrayList<>();
        for (Participant p : participantRepository.getAllParticipant()) {
            if (p.getFilmName().equals(filmName) && p.getType().equals("Actor")) {
                if (!actorsId.contains(p.getPerson_id())) {
                    actorsId.add(p.getPerson_id());
                }
            }
        }
        List<Person> actors = new ArrayList<>();
        for (Person p : personRepository.findAll()) {
            if (actorsId.contains(p.getId())) {
                p.setPersonFunction(Person.Type.Actor);
                actors.add(p);
            }
        }
        connectionPool.releaseConnection(connection1);
        connectionPool.releaseConnection(connection2);
        return actors.toArray(new Person[0]);
    }

    public Film[] getAllFilms(int year) {
        Connection connection = connectionPool.getConnection();
        filmRepository = new FilmRepositoryImpl(connection);
        List<Film> filmList = filmRepository.getAllFilms().stream().filter(x -> x.getDate().compareTo(Date.valueOf(year + 1 + "-01-01")) < 0).toList();
        connectionPool.releaseConnection(connection);
        return filmList.toArray(new Film[0]);
    }

    public Person[] getActorsWithNotLessFilmThen(int counter) {
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl(connection1);
        PersonRepository personRepository = new PersonRepositoryImpl(connection1);
        for (Participant p : participantRepository.getAllParticipant()) {
            if (p.getType().equals("Actor")) {
                if (hashtable.containsKey(p.getPerson_id())) {
                    hashtable.put(p.getPerson_id(), hashtable.get(p.getPerson_id()) + 1);
                } else {
                    hashtable.put(p.getPerson_id(), 1);
                }
            }
        }
        List<Person> actors = new ArrayList<>();
        Enumeration<Integer> e = hashtable.keys();
        while (e.hasMoreElements()) {
            int key = e.nextElement();
            if (key >= counter) {
                Person person = personRepository.getPerson(key);
                person.setPersonFunction(Person.Type.Actor);
                actors.add(person);
            }
        }
        System.out.println(actors);
        connectionPool.releaseConnection(connection1);
        connectionPool.releaseConnection(connection2);
        return actors.toArray(new Person[0]);
    }

    public Person[] getActorsWhichWasDirector() {
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(connection1);
        ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl(connection2);
        List<Integer> directorsId = new ArrayList<>();
        List<Integer> actorsId = new ArrayList<>();
        for (Participant p : participantRepository.getAllParticipant()) {
            if (p.getType().equals("Director")) {
                if (!directorsId.contains(p.getPerson_id())) {
                    directorsId.add(p.getPerson_id());
                }
            }
        }
        for (Participant p : participantRepository.getAllParticipant()) {
            if (directorsId.contains(p.getPerson_id()) && p.getType().equals("Actor")) {
                if (!actorsId.contains(p.getPerson_id())) {
                    actorsId.add(p.getPerson_id());
                }
            }
        }
        List<Person> actors = new ArrayList<>();
        for (Person p : personRepository.findAll()) {
            if (actorsId.contains(p.getId())) {
                p.setPersonFunction(Person.Type.Actor);
                actors.add(p);
            }
        }
        ;
        System.out.println(actors);
        connectionPool.releaseConnection(connection1);
        connectionPool.releaseConnection(connection2);
        return actors.toArray(new Person[0]);
    }

    public boolean deleteFilmWithOlderThenNYear(int years) {
        boolean flag = false;
        Connection connection = connectionPool.getConnection();
        filmRepository = new FilmRepositoryImpl(connection);
        List<Film> filmList = filmRepository.getAllFilms().stream().
                filter(x -> x.getDate().compareTo(new Date(System.currentTimeMillis()-
                        (long) years *1000*60*60*24*365-1000*60*60*24)) > 0).toList();
        for (Film film : filmList) {
             filmRepository.deleteFilm(film);
             flag = true;
        }
        return flag;
    }
}
