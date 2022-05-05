package ua.advanced.practice7;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private Type personFunction;

    public Person(String surname, String name, String patronymic, Type personFunction) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.personFunction = personFunction;
    }

    enum Type{
        Actor, Director
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
}
