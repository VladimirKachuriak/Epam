package ua.advanced.practice5.task10;

public class Stock {
    private Company company;
    private int stockCount;

    public Stock(Company company, int stockCount) {
        this.company = company;
        this.stockCount = stockCount;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
    public Company getCompany(){
        return company;
    }
}
