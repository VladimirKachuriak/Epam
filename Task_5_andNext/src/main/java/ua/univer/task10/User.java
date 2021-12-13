package ua.univer.task10;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class User {
    private String name;
    private String position;
    private BigDecimal salary;
    private String month;


    public User(String name, String position, double salary, String month) {
        this.name = name;
        this.position = position;
        this.salary = BigDecimal.valueOf(salary);
        this.salary = this.salary.setScale(2, RoundingMode.HALF_UP);
        this.month = month;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.add(BigDecimal.valueOf(salary));
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", month=" + month +
                '}';
    }
}
