package ua.advanced.practice5.task10;

public class Company {
    private String name;
    private double indexPerStock;
    private int capital;
    private boolean isWork = true;

    public Company(String name,double indexPerStock, int capital) {
        this.name = name;
        this.indexPerStock = indexPerStock;
        this.capital = capital;
    }

    public synchronized int buyStock(int money){
        int result = (int) (money*indexPerStock);
        capital+=money;
        indexPerStock+=  money*0.0001;
        System.out.println("Buy"+name+": index "+indexPerStock);
        return result;
    }
    public synchronized int sellStock(int stock){
        int result = (int) (stock/indexPerStock);
        capital-=stock/indexPerStock;
        indexPerStock-= indexPerStock*0.0001;
        System.out.println("SELL"+name+": index "+indexPerStock);
        return result;
    }

    public double getIndexPerStock() {
        return indexPerStock;
    }

    public int getCapital() {
        return capital;
    }

    public boolean isWork() {
        return isWork;
    }

    public synchronized void setWork(boolean work) {
        isWork = work;
    }

    public String getName() {
        return name;
    }
}
