package ua.univer.task06;

import java.io.Console;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
      System.out.println("fdsf");
      Employee[] employee = {new Manager("Larisa",new BigDecimal(1000),100),new SalesPerson("Svetlana",new BigDecimal(2000),100)};
      Company company = new Company(employee);

      company.giveEverbodyBonus(new BigDecimal("300.11"));
        System.out.println(company.nameMaxSalary());

        System.out.println(company.totalToPay());


    }
}
