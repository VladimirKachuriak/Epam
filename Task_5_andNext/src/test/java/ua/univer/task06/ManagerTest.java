package ua.univer.task06;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void setBonus() {
        Manager manager = new Manager("Kolesnik", new BigDecimal(10000), 124);
        manager.setBonus(new BigDecimal(2000));
        assertEquals("Bonus set is incorrect", new BigDecimal("2500.00"), manager.getBonus());
        Manager manager2 = new Manager("Yarmak", new BigDecimal(8000), 255);
        manager2.setBonus(new BigDecimal(1000));
        assertEquals("Bonus set is incorrect", new BigDecimal("2000.00"), manager2.getBonus());
    }
}