package ua.univer.task07;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void addDeposit() {
        Client client = new Client();
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//1
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//2
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//3
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//4
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//5
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//6
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//7
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//8
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//9
        assertEquals("",true,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//10
        assertEquals("",false,client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2)));//11
    }

    @Test
    public void totalIncome() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2));
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),2));
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2));
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),2));
        client.addDeposit(new LongDeposit(new BigDecimal("1000"),2));
        client.addDeposit(new LongDeposit(new BigDecimal("1000"),2));

        assertEquals("",new BigDecimal("265.40"),client.totalIncome());

    }

    @Test
    public void maxIncome() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),1));//Income =  50
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),1));//Income =  10.00
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2));//Income =  102.50
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),2));//Income =  30.20
        client.addDeposit(new LongDeposit(new BigDecimal("1500"),5));//Income =  00.00
        client.addDeposit(new LongDeposit(new BigDecimal("1500"),8));//Income =  483.75

        assertEquals("",new BigDecimal("483.75"),client.maxIncome());
    }

    @Test
    public void getIncomeByNumber() {
        Client client = new Client();
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),1));//Income =  50
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),1));//Income =  10.00
        client.addDeposit(new BaseDeposit(new BigDecimal("1000"),2));//Income =  102.50
        client.addDeposit(new SpecialDeposit(new BigDecimal("1000"),2));//Income =  30.20
        client.addDeposit(new LongDeposit(new BigDecimal("1500"),5));//Income =  00.00
        client.addDeposit(new LongDeposit(new BigDecimal("1500"),8));//Income =  483.75

        assertEquals("",new BigDecimal("0.00"),client.getIncomeByNumber(40));
        assertEquals("",new BigDecimal("50.00"),client.getIncomeByNumber(0));
        assertEquals("",new BigDecimal("0.00"),client.getIncomeByNumber(-10));
        assertEquals("",new BigDecimal("483.75"),client.getIncomeByNumber(5));
        assertEquals("",new BigDecimal("0.00"),client.getIncomeByNumber(6));
    }
}