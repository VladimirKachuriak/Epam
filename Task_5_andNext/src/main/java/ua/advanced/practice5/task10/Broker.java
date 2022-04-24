package ua.advanced.practice5.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Broker implements Runnable {
    private int id;
    private int cash;
    private List<Stock> stocks = new ArrayList<>();

    public Broker(int id, int cash, List<Stock> stocks) {
        this.id = id;
        this.cash = cash;
        this.stocks = stocks;
    }

    @Override
    public void run() {
        while (true) {
            for (Stock stock : stocks) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int operation = new Random().nextInt(2);
                Stock stock1 = stocks.get(new Random().nextInt(stocks.size()));
                if(stock1.getCompany().isWork()) {
                    switch (operation) {
                        case 0://buy stock
                            int cashTemp = (int) (new Random().nextInt(cash)*0.2);
                            stock1.setStockCount(stock1.getStockCount()+stock1.getCompany().buyStock(cashTemp));
                            cash-=cashTemp;
                            break;
                        case 1://sell stock
                            int stockTemp = (int) (new Random().nextInt(stock1.getStockCount())*0.2);
                            cash+=(stock1.getCompany().sellStock(stockTemp));
                            stock1.setStockCount(stock1.getStockCount()- stockTemp);
                            break;
                    }
                    System.out.println("Broker #"+id+" cash"+cash);
                }else{
                    System.out.println(stock1.getCompany().getName()+"Company if freeze");
                }
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}
