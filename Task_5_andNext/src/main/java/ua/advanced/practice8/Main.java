package ua.advanced.practice8;

import ua.advanced.practice8.Entity.Film;
import ua.advanced.practice8.EntityDAO.FilmDAO;

import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws SQLException {

        Videoteka videoteka = new Videoteka();
        videoteka.getActorsWhichWasDirector();
        videoteka.getActorsWithNotLessFilmThen(2);
        System.out.println(Arrays.toString(videoteka.getAllFilms(1999)));
        System.out.println(Arrays.toString(videoteka.getActorsFromFilm("Matrix")));
        videoteka.deleteFilmWithOlderThenNYear(15);
    }
}
