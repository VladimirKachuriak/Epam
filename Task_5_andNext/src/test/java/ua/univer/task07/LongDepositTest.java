package ua.univer.task07;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LongDepositTest {

    @Test
    public void income() {
        LongDeposit longDeposit1 = new LongDeposit(new BigDecimal("1000"),5);
        assertEquals("Result is incorrect",new BigDecimal("0.00"),longDeposit1.income());

        LongDeposit longDeposit2 = new LongDeposit(new BigDecimal("1000.00"),7);
        assertEquals("Result is incorrect",new BigDecimal("150.00"),longDeposit2.income());
    }
}