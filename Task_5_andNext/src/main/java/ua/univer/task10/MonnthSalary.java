package ua.univer.task10;

import java.math.BigDecimal;

public class MonnthSalary {
    private String month;
    private BigDecimal Salary;
    private int counter;

    public MonnthSalary(String month, BigDecimal salary) {
        this.month = month;
        Salary = salary;
        counter = 1;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        Salary = salary;
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public BigDecimal getMedium() {
        return Salary.divide(new BigDecimal(counter));
    }

    @Override
    public String toString() {
        return "MontchSalary{" +
                "month='" + month + '\'' +
                ", Medium=" + getMedium() +
                '}';
    }
}
