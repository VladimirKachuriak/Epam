package ua.advanced.practice7;

import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws SQLException {

        Videoteka videoteka = new Videoteka();
        System.out.println(Arrays.toString(videoteka.getAllFilms(2022)));
        System.out.println(Arrays.toString(videoteka.getActorsFromFilm("Titanic")));
        videoteka.getActorsWithNotLessFilmThen(1);
        videoteka.getActorsWhichWasDirector();
        videoteka.deleteFilmWithOlderThenNYear(3);

    }
}
