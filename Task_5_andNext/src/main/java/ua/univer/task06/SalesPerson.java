package ua.univer.task06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesPerson extends Employee {
    private int percent;
    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);
        this.percent = percent;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        bonus = bonus.setScale(2, RoundingMode.HALF_UP);
         if(percent>200){
             this.bonus = bonus.multiply(BigDecimal.valueOf(3));
         }else if(percent>100){
             this.bonus = bonus.multiply(BigDecimal.valueOf(2));
         }else {
             this.bonus = bonus;
         }
    }
}
