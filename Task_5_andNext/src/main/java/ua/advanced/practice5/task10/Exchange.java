package ua.advanced.practice5.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exchange {
    private List<Company> companyList = new ArrayList<>();
    private List<Broker> brokers = new ArrayList<>();

    public Exchange(int countOfBroker, List<Company> companys) {
        this.companyList = companys;
        for (int i = 0; i < countOfBroker; i++) {
            List<Stock> stocks = new ArrayList<>();
            for (Company company : companyList) {
                stocks.add(new Stock(company, new Random().nextInt(50)));
            }
            brokers.add(new Broker(i, new Random().nextInt(500), stocks));
        }
    }

    public void start() {
        for (Broker broker : brokers) {
            new Thread(broker).start();
        }
        new Thread(() -> {
            while (true) {
                for (Company company: companyList) {
                    if(company.isWork() && company.getIndexPerStock()<2){
                        company.setWork(false);
                    }
                }
            }
        }).start();
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }
}
