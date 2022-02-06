package ua.advanced.practice1.task1.house;

import ua.advanced.practice1.task1.residents.cats.Cat;
import ua.advanced.practice1.task1.residents.dogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class House<T> {

    private final List<T> residents = new ArrayList();

    public void enter(T resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (T resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
