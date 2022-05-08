package ua.advanced.practice8.Repository;

import ua.advanced.practice8.Entity.Film;

import java.util.List;

public interface FilmRepository {
    Film findFilm(String name);
    boolean addFilm(Film film);
    boolean deleteFilm(Film film);
    boolean updateFilm(Film film);
    List<Film> getAllFilms();
}
