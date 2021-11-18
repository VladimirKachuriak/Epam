package ua.univer.task05;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) throws IllegalArgumentException{
        if(sideA < 0 || sideB < 0)throw new IllegalArgumentException("Your parameter can't be less then zero");
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double sideA) {
        this(sideA, 5);
    }

    public Rectangle()  {
        this(4, 3);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimetr() {
        return 2 * (sideA + sideB);
    }

    public boolean isSquare() {
        return (sideA == sideB) ? true : false;
    }

    public void replaceSides(){
        double temp = sideA;
        sideA = sideB;
        sideB = sideA;
    }
}
