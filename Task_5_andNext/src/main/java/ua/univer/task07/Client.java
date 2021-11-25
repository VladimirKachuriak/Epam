package ua.univer.task07;

import java.math.BigDecimal;

public class Client {
    private Deposit[] deposits = new Deposit[10];
    private int lindex = -1;

    public boolean addDeposit(Deposit deposit) {
        if (lindex +1 < deposits.length) {
            deposits[++lindex] = deposit;
            return true;
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal term = new BigDecimal("0");
        for (int i = 0; i <= lindex; i++) {
            term = term.add(deposits[i].income());
        }
        return term;
    }

    public BigDecimal maxIncome() {
        if (lindex == -1)return new BigDecimal("0");
            int max_index = 0;
        for (int i = 0; i <= lindex; i++) {
            if (deposits[max_index].income().compareTo(deposits[i].income()) == -1) {
                max_index = i;
            }
        }
        return deposits[max_index].income();
    }

    public BigDecimal getIncomeByNumber(int deposit_index) {
        if(deposit_index >=0 && deposit_index<=lindex) return deposits[deposit_index].income();
        return new BigDecimal("0.00");

    }
}
