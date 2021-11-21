package ua.univer.task06;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CompanyTest {
    private static Company company;
    @BeforeClass
    public static void init() {
        Employee[] employee = {new Manager("Levsha", new BigDecimal(1000), 100),
                new SalesPerson("Pavlov", new BigDecimal(2000), 100),
                new Manager("Podoba", new BigDecimal(2000), 200),};
                company = new Company(employee);
                company.giveEverbodyBonus(new BigDecimal("300.111"));
    }


    @Test
    public void totalToPay() {
        assertEquals("Incorrect salary result",new BigDecimal("6900.33"),company.totalToPay());
    }

    @Test
    public void nameMaxSalary() {
        assertEquals("the name of the employee with the maximum salary is incorrect ","Podoba",company.nameMaxSalary());
    }
}