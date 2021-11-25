package ua.univer.task07;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BaseDepositTest {

    @Test
    public void income() {
        BaseDeposit baseDeposit1 = new BaseDeposit(new BigDecimal("1000"),3);
        assertEquals("Result is incorrect",new BigDecimal("157.62"),baseDeposit1.income());

        BaseDeposit baseDeposit2 = new BaseDeposit(new BigDecimal("1000.00"),2);
        assertEquals("Result is incorrect",new BigDecimal("102.50"),baseDeposit2.income());
    }
}