package ua.univer.task07;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SpecialDepositTest {

    @Test
    public void income() {
        SpecialDeposit specialDeposit1 = new SpecialDeposit(new BigDecimal("1000"),1);
        assertEquals("Result is incorrect",new BigDecimal("10.00"),specialDeposit1.income());

        SpecialDeposit specialDeposit2 = new SpecialDeposit(new BigDecimal("1000.00"),2);
        assertEquals("Result is incorrect",new BigDecimal("30.20"),specialDeposit2.income());
    }
}