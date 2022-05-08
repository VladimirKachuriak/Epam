package ua.advanced.practice8;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class VideotekaTest {


    @Test
    void getActorsFromFilm() throws SQLException {
        Videoteka videoteka = new Videoteka();
        videoteka.getActorsFromFilm("Matrix");
        assertEquals("[Person{surname='Pitt', name='Brad', patronymic='William', personFunction=Actor}, " +
                "Person{surname='charles', name='Keanu', patronymic='Reves', personFunction=Actor}]", Arrays.toString(videoteka.getActorsFromFilm("Matrix")));
        assertEquals("[]", Arrays.toString(videoteka.getActorsFromFilm("Matrix3")));
    }

    @Test
    void getAllFilms() throws SQLException {
        Videoteka videoteka = new Videoteka();//output films which release this or previous year
        assertEquals("[Film{filmName='Matrix', date=1999-01-01, country='USA'}]", Arrays.toString(videoteka.getAllFilms(2000)));
        assertEquals("[Film{filmName='Matrix', date=1999-01-01, country='USA'}, " +
                "Film{filmName='Matrix2', date=2003-05-04, country='Canada'}]", Arrays.toString(videoteka.getAllFilms(2003)));
    }

    @Test
    void getActorsWithNotLessFilmThen() throws SQLException {
        Videoteka videoteka = new Videoteka();
    }

    @Test
    void getActorsWhichWasDirector() throws SQLException {
        Videoteka videoteka = new Videoteka();
        assertEquals("[Person{surname='Pitt', name='Brad', patronymic='William', personFunction=Actor}, Person{surname='Sasha', name='Makuh', patronymic='Serhii', personFunction=Actor}]",Arrays.toString(videoteka.getActorsWhichWasDirector()));
    }

    @Test
    void deleteFilmWithOlderThenNYear() throws SQLException {
        Videoteka videoteka = new Videoteka();
        assertTrue(videoteka.deleteFilmWithOlderThenNYear(1));
        assertTrue(videoteka.deleteFilmWithOlderThenNYear(10));
    }
}