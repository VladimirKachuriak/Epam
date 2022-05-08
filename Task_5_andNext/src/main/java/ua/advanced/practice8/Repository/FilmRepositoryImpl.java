package ua.advanced.practice8.Repository;

import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.Entity.Participant;
import ua.advanced.practice8.EntityDAO.FilmDAO;
import ua.advanced.practice8.EntityDAO.ParticipantDAO;

import java.sql.Connection;
import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {
    private Connection connection;
    private FilmDAO filmDAO;
    private ParticipantDAO participantDAO;

    public FilmRepositoryImpl(Connection connection) {
        filmDAO = new FilmDAO(connection);
        participantDAO = new ParticipantDAO(connection);
    }

    @Override
    public Film findFilm(String name) {
        return filmDAO.read(name);
    }

    @Override
    public boolean addFilm(Film film) {
        if (!filmDAO.findAll().contains(film)) {
            filmDAO.create(film);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFilm(Film film) {
        if (filmDAO.findAll().contains(film)) {
            participantDAO.deleteFilm(film.getFilmName());
            filmDAO.delete(film);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFilm(Film film) {
        if (filmDAO.findAll().contains(film)) {
            filmDAO.update(film);
            return true;
        }
        return false;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDAO.findAll();
    }
}
