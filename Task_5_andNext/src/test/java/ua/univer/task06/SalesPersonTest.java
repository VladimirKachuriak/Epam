package ua.univer.task06;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SalesPersonTest {

    @Test
    public void setBonus() {
        SalesPerson manager = new SalesPerson("Koval", new BigDecimal(15000), 50);
        manager.setBonus(new BigDecimal(2000));
        assertEquals("Bonus set is incorrect", new BigDecimal("2000.00"), manager.getBonus());
        SalesPerson manager2 = new SalesPerson("Yarmak", new BigDecimal(8000), 240);
        manager2.setBonus(new BigDecimal(1000));
        assertEquals("Bonus set is incorrect", new BigDecimal("3000.00"), manager2.getBonus());
    }
}