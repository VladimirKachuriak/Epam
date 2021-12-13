package ua.univer.task10;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonthParserTest {


    @Test
    public void getUserWithMaxSalary() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 1000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5500, "kviten"));
        list.add(new User("Тимченко", "мер", 3000, "kviten"));
        Assert.assertEquals(new BigDecimal("5500.00"), MonthParser.getUserWithMaxSalary(list).get(0).getSalary());
    }

    @Test
    public void getUserWithMinSalary() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 1000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5500, "kviten"));
        list.add(new User("Тимченко", "мер", 3000, "kviten"));
        Assert.assertEquals(new BigDecimal("1000.00"), MonthParser.getUserWithMinSalary(list).get(0).getSalary());
    }

    @Test
    public void getUserWithMediumSalary() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 2000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5400, "kviten"));
        list.add(new User("Тимченко", "мер", 2500, "kviten"));
        Assert.assertEquals(new BigDecimal("3300.00"), MonthParser.getMediumSalary(list));
    }

    @Test
    public void getUserWithDespersian() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 2000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5400, "kviten"));
        list.add(new User("Тимченко", "мер", 2500, "kviten"));
        list.add(new User("Ковальчук", "мер", 3500, "kviten"));
        list.add(new User("Авраменко", "мер", 4000, "kviten"));
        Assert.assertEquals(2, MonthParser.getUserWithDespersian(list).stream().count());
    }

    @Test
    public void getMonthMediumSalary() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 2000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5400, "kviten"));
        list.add(new User("Тимченко", "мер", 2500, "kviten"));
        list.add(new User("Ковальчук", "мер", 3500, "kviten"));
        list.add(new User("Авраменко", "мер", 4000, "kviten"));
        Assert.assertEquals(new BigDecimal("3850.00"), MonthParser.getMonthMediumSalary(list).get(0).getMedium());
    }

    @Test
    public void getMaxSalaryMonth() {
        List<User> list = new ArrayList<>();
        list.add(new User("Кличко", "мер", 2000, "kviten"));
        list.add(new User("Дмитрук", "мер", 5400, "veresen"));
        list.add(new User("Тимченко", "мер", 2500, "kviten"));
        list.add(new User("Ковальчук", "мер", 3500, "serpen"));
        list.add(new User("Авраменко", "мер", 4000, "serpen"));
        Assert.assertEquals("veresen", MonthParser.getMaxSalaryMonth(MonthParser.getMonthMediumSalary(list)).getMonth());
    }
}