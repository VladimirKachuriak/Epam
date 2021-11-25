package ua.univer.task07;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BaseDeposit baseDeposit=new BaseDeposit(new BigDecimal("1000"),3);
        System.out.println(baseDeposit.income());
        SpecialDeposit specialDeposit=new SpecialDeposit(new BigDecimal("1000"),2);
        System.out.println(specialDeposit.income());
        LongDeposit longDeposit=new LongDeposit(new BigDecimal("1000"),7);
        System.out.println(longDeposit.income());
        Client client = new Client();
        client.addDeposit(baseDeposit);
        client.addDeposit(specialDeposit);
        client.addDeposit(longDeposit);
        System.out.println("max= "+client.maxIncome());
    }
}
