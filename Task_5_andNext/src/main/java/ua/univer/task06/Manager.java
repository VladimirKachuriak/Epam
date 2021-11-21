package ua.univer.task06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Manager extends Employee {
    private int quantity;

    public Manager(String name, BigDecimal salary, int quantity) {
        super(name, salary);
        this.quantity = quantity;
    }


    @Override
    void setBonus(BigDecimal bonus) {
        bonus = bonus.setScale(2, RoundingMode.HALF_UP);
        if (quantity > 150) {
            this.bonus = bonus.add(BigDecimal.valueOf(1000));
        } else if (quantity > 100) {
            this.bonus = bonus.add(BigDecimal.valueOf(500));
        } else {
            this.bonus = bonus;
        }
    }
}
