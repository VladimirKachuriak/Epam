package org.example.Service;

import org.example.Model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    public static List<Car> sortCarByPrice(List<Car> cars) {
        return cars.stream().sorted(Comparator.comparingInt(Car::getPrice)).collect(Collectors.toList());
    }

    public static List<Car> sortCarByModel(List<Car> cars) {
        return cars.stream().sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
    }

    public static void carDesc(List<Car> cars) {
        Collections.reverse(cars);
    }

    public static List<Car> filterModel(List<Car> cars, String name) {
        return cars.stream().filter(x -> x.getBrand().equals(name)).collect(Collectors.toList());
    }

    public static List<Car> filterAutoClass(List<Car> cars, String rate) {
        return cars.stream().filter(x -> x.getAutoClass().toString().equals(rate)).collect(Collectors.toList());
    }

    public static List<String> getAllBrand(List<Car> cars) {
        List<String> list = new ArrayList<>();
        for (Car car : cars) {
            if(!list.contains(car.getBrand())){
                list.add(car.getBrand());
            }
        }
        return list;
    }

    public static List<Car> diapasonCars(List<Car> cars,int from,int to) {
        List<Car> cars1 = new ArrayList<>();
        for (int i = from; i < to && i<cars.size(); i++) {
            cars1.add(cars.get(i));
        }
        return cars1;
    }
}
