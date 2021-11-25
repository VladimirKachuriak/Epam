package ua.univer.task07;

import java.math.BigDecimal;

public abstract class Deposit {
    private BigDecimal money;
    private int period;

    public Deposit(BigDecimal money, int period) {
        this.money = money;
        this.period = period;
    }

    public BigDecimal amount() {
        return money;
    }

    public int getPeriod() {
        return period;
    }
    public abstract BigDecimal income();

}
