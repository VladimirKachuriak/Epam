package ua.advanced.practice5.task11;

public class Plane {
    private int id;
    private static int counter=0;
    private int countOfPeople;
    private int numberOfTrap;
    private RouteDistance route;

    public Plane(int countOfPeople, int numberOfTrap, RouteDistance route) {
        this.countOfPeople = countOfPeople;
        this.numberOfTrap = numberOfTrap;
        this.route = route;
        id = counter++;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public int getNumberOfTrap() {
        return numberOfTrap;
    }

    public RouteDistance getRoute() {
        return route;
    }

    public int getId() {
        return id;
    }
}
