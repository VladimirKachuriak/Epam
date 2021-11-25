package ua.univer.task07;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit{
    public LongDeposit(BigDecimal money, int period) {
        super(money, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal term = new BigDecimal(amount().toString());
        for (int i = 6; i < getPeriod(); i++) {
            term = term.multiply(new BigDecimal("1.15"));
        }
        term = term.subtract(amount());
        term = term.setScale(2, RoundingMode.DOWN);
        return term;
    }
}
