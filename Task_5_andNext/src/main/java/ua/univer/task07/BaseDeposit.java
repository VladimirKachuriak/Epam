package ua.univer.task07;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit{

    public BaseDeposit(BigDecimal money, int period) {
        super(money, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal term = new BigDecimal(amount().toString());
        for (int i = 0; i < getPeriod(); i++) {
             term = term.multiply(new BigDecimal("1.05"));
        }
        term = term.subtract(amount());
        term = term.setScale(2,RoundingMode.DOWN);
        return term;
    }
}
