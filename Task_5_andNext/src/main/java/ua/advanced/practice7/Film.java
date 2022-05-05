package ua.advanced.practice7;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Film {
    private String filmName;
    private Date date;

    public Film( String filmName, Date date) {
        this.filmName = filmName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", date=" + date +
                '}';
    }
}
