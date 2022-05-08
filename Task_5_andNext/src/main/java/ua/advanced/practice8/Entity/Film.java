package ua.advanced.practice8.Entity;

import java.sql.Date;
import java.util.Objects;

public class Film {
    private String filmName;
    private Date date;
    private String country;

    public Film( String filmName, Date date, String country) {
        this.filmName = filmName;
        this.date = date;
        this.country = country;
    }


    public String getFilmName() {
        return filmName;
    }

    public Date getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", date=" + date +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmName.equals(film.filmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName);
    }
}
