package ua.advanced.practice8.Entity;

import java.sql.Date;
import java.util.Objects;

public class Person {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;
    private Type personFunction;

    public Person(String surname, String name, String patronymic,Date birthdate) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
    }

    public enum Type{
        Actor, Director
    }

    public Type getPersonFunction() {
        return personFunction;
    }

    public void setPersonFunction(Type personFunction) {
        this.personFunction = personFunction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", personFunction=" + personFunction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return surname.equals(person.surname) && name.equals(person.name) && patronymic.equals(person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic);
    }
}
