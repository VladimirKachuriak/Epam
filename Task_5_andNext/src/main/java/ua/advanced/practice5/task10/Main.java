package ua.advanced.practice5.task10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<Company> companyList = new ArrayList<>();
         companyList.add(new Company("Google",3.5,5000));
         companyList.add(new Company("Microsoft",2,10000));
         companyList.add(new Company("xiomi",2.5,2000));
         Exchange exchange = new Exchange(5, companyList);
         exchange.start();
    }
}
