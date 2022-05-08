package ua.advanced.practice8.Entity;

import java.util.Objects;

public class Participant {
    private String filmName;
    private int person_id;
    private String type;

    public Participant(String filmName, int person_id, Person.Type type) {
        this.filmName = filmName;
        this.person_id = person_id;
        this.type = typeToString(type);
    }

    public String getFilmName() {
        return filmName;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getType() {
        return type;
    }

    private String typeToString(Person.Type type){
        if(Person.Type.Actor == type){
            return "Actor";
        }else {
            return "Director";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return person_id == that.person_id && filmName.equals(that.filmName) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, person_id, type);
    }
}
