package ua.univer.task06;

import java.math.BigDecimal;

public class Company {
    private Employee[] staff;

    public Company(Employee[] staff) {
        this.staff = staff;
    }

    public void giveEverbodyBonus(BigDecimal money){
        for (Employee e: staff) {
            e.setBonus(money);
        }
    }
    public BigDecimal totalToPay(){
        BigDecimal counter = new BigDecimal(0);
        for (Employee e: staff) {
            counter = counter.add(e.toPay());
        }
        return counter;
    }
    public String nameMaxSalary(){
        int index = 0;
        for (int i = 1; i < staff.length; i++) {
            if(staff[index].toPay().compareTo(staff[i].toPay())<0){

                index = i;
            }
        }
        return staff[index].getName();
    }
}
