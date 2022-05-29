package org.example.Service;

import org.example.Model.Car;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarServiceTest {

    @Test
    public void sortCarByPrice() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().id(1).price(21).build());
        cars.add(new Car.CarBuilder().id(2).price(11).build());
        cars.add(new Car.CarBuilder().id(3).price(54).build());

        assertEquals("[Car{id=2, brand='null', model='null', releaseDate=null, state=null, autoClass=null, price=11}, " +
                "Car{id=1, brand='null', model='null', releaseDate=null, state=null, autoClass=null, price=21}, " +
                "Car{id=3, brand='null', model='null', releaseDate=null, state=null, autoClass=null, price=54}]", CarService.sortCarByPrice(cars).toString());
    }

    @Test
    public void sortCarByModel() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().model("A").build());
        cars.add(new Car.CarBuilder().model("C").build());
        cars.add(new Car.CarBuilder().model("B").build());

        assertEquals("[Car{id=0, brand='null', model='A', releaseDate=null, state=null, autoClass=null, price=0}, " +
                "Car{id=0, brand='null', model='B', releaseDate=null, state=null, autoClass=null, price=0}, " +
                "Car{id=0, brand='null', model='C', releaseDate=null, state=null, autoClass=null, price=0}]", CarService.sortCarByModel(cars).toString());
    }

    @Test
    public void carDesc() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().brand("A").build());
        cars.add(new Car.CarBuilder().brand("C").build());
        cars.add(new Car.CarBuilder().brand("B").build());

        CarService.carDesc(cars);
        assertEquals("[Car{id=0, brand='B', model='null', releaseDate=null, state=null, autoClass=null, price=0}, " +
                "Car{id=0, brand='C', model='null', releaseDate=null, state=null, autoClass=null, price=0}, " +
                "Car{id=0, brand='A', model='null', releaseDate=null, state=null, autoClass=null, price=0}]", cars.toString());
    }

    @Test
    public void filterModel() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().brand("A").build());
        cars.add(new Car.CarBuilder().brand("C").build());
        cars.add(new Car.CarBuilder().brand("B").build());

        assertEquals("[Car{id=0, brand='A', model='null', releaseDate=null, state=null, autoClass=null, price=0}]", CarService.filterModel(cars,"A").toString());
    }

    @Test
    public void getAllBrand() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().brand("A").build());
        cars.add(new Car.CarBuilder().brand("B").build());
        cars.add(new Car.CarBuilder().brand("B").build());
        assertEquals("[A, B]", CarService.getAllBrand(cars).toString());
    }

    @Test
    public void diapasonCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car.CarBuilder().id(1).build());
        cars.add(new Car.CarBuilder().id(2).build());
        cars.add(new Car.CarBuilder().id(3).build());
        assertEquals("[Car{id=2, brand='null', model='null', releaseDate=null, state=null, autoClass=null, price=0}]", CarService.diapasonCars(cars,1,2).toString());
    }
}