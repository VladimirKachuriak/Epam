package ua.univer.task06;

import java.math.BigDecimal;

public abstract class Employee {
    private String name;
    private BigDecimal salary;
    protected BigDecimal bonus = new BigDecimal(0);

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
        bonus.setScale(2);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    abstract void setBonus(BigDecimal bonus);

    public BigDecimal toPay(){
        return salary.add(bonus);
    }
}
