package ua.advanced.practice5.task9;

public class Lot {
    private String name;
    private int basePrice;

    public Lot(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
